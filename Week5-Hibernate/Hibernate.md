# Hibernate
- Hibernate is an ORM tool (Object Relational Mapping)
- It is used to configure (map) the relationships between our java application (objects) and our database (relational)
- Hibernate is built on top of JDBC and abstracts away all of the "ceremony" or boiler plate code associated with JDBC
    - How much of writing your DAO's was the same each time?
    - establishing our connection, creating a PreparedStatement, manually mapping out each field to the correct column in the database, executing it, getting back the results, closing resources
- Instead, we establish relationships once, and each time we use an object, Hibernate relies on that mapping to understand how to convert objects into DB records.
- Establishing these relationships has many benefits to us as developers:
    - have the ability to use a code first approach when creating our database, meaning that we can generate our database entities automatically from our Java classes; this removes the obstacle of matching columns names and data types as that is abstracted away
    - manual mapping does not need to occur in DAO's, where each column is matched with each field
    - we can use hibernate methods which interact with our database and abstract away JDBC and allow us to perform db operations more simply

** Note: My notes/examples use Hibernate 5. Hibernate versions 4/5 are similar except for the way SessionFactory creation is handled and the move from Criteria to CriteriaQuery. If you reference any external resources, make sure to keep this in mind **

## Configuring Hibernate
In order to configure Hibernate one needs:
1. Hibernate Configuration (hibernate.cfg.xml file)
2. Hibernate Mapping (hbm.xml files or annotations)

(we also need to configure our pom.xml - hibernate, yes, but still with jdbc as it leverages jdbc)

The goal of this configuration is to create a properly configured Session Factory, which we can obtain a Session  from and with which we can perform operations on our database.

### SessionFactory (Interface)
- a more heavyweight object which stores our database credentials and configuration
- acts as a factory for hibernate sessions
- is thread-safe and usually implemented as a singleton
- life cycle of a SessionFactory is the life cycle of the java application

### Session (Interface)
- hibernate session ≠ http session
- session is a lightweight object that represents the main interface between java and hibernate
- a session facilitates CRUD operations on our mapped entities (Sessions are going to be the basis for implementing our DAO's)
- life cycle of a session object is that of a logical transaction (can include several physical transactions)

## Creating a Session Factory and Utilizing Sessions

Creating a Session Factory
- use a StandardServiceRegistry
- configure MetaData and MetaDataSources

``` java
public class HibernateUtil {
	
	
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;
	
	private static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
		      try {
		        // Create registry
		    	   registry = new StandardServiceRegistryBuilder().configure().build();

		        // Create MetadataSources
		        MetadataSources sources = new MetadataSources(registry);

		        // Create Metadata
		        Metadata metadata = sources.getMetadataBuilder().build();

		        // Create SessionFactory
		        sessionFactory = metadata.getSessionFactoryBuilder().build();

		      } catch (Exception e) {
		        e.printStackTrace();
		        if (registry != null) {
		          StandardServiceRegistryBuilder.destroy(registry);
		        }
		      }
		    }
		    return sessionFactory;
	}
	
    //invoke this method to get an instance of an object implementing Session
	public static Session getSession() {
		return getSessionFactory().openSession();
	}

}


Session s = HibernateUtil.getSession();
// Once a session is obtained, a variety of session methods can be invoked to perform operations on our DB
// save, persist
// get, load
// update, merge
// getCriteriaBuilder
// createQuery
// beginTransaction
```

## Hibernate Configuration Revisited
So how does our session factory know how to prepare our sessions? How does it have our DB credentials? (they're not provided in the HibernateUtil file above) How is Hibernate aware of our Object/Record mappings?

## Global Hibernate Configuration
- an xml file which provides session factory level configuration
    - url
    - pass
    - driver class
    - relationship to schema generation
    - show ddl
    - specify dialect
- hibernate.cfg.xml located in src>main>resources

``` xml
<hibernate-configuration>
	<session-factory>
		<property name="hibernate.connection.url">jdbc:postgresql://url:5432/postgres</property>
		<property name="hibernate.connection.username">user</property>
		<property name="hibernate.connection.password">pass</property>
		<property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
	
		<property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
		<property name="hibernate.hbm2ddl.auto">validate</property>

		<property name="hibernate.show_sql">true</property>
		
		<!-- include our mapping resources (hbm files) or classes (where we have annotations) -->
		<mapping class="" />  <!-- looks in src/main/java for a class -->
		<mapping resource="" /> <!-- looks in src/main/resources hbm.xml -->
	</session-factory>
</hibernate-configuration>
```
- hbm2ddl.auto describes the relationship between your application and schema definition (will it create the tables in the db?) It can have four values:
    1. validate - will not change the schema; an exception will be thrown if it does not correspond to the mapping
    2. update - will update the schema where there are differences 
    3. create - recreates any tables (drops existing and creates new tables)
    4. create-drop - creates the tables in the application startup and drops them at the shutdown of the application
    - this tool is really helpful for us but hbm2ddl should never be set to a value other than validate in any non local environment (don't want our dev/production environments schemas affected)  
- show_sql will print the sql statements 

### Mapping Configuration
- we need to provide configuration for how to map our java entities to our database entities
- this is either done with xml 'hbm' files or with annotations
- below is an example hbm file, mapping a java "Bear" class to a table in our db

``` xml
<hibernate-mapping>
	<class name="com.revature.models.Bear">
		<id name="id" column="BEAR_ID">
			<generator class="increment"></generator>
		</id>
		<property name="name" type="org.hibernate.type.StringType" column="BEAR_NAME"></property>
		<property name="birthday" type="org.hibernate.type.DateType"></property>
		<many-to-one name="cave" column="CAVE_ID" class="com.revature.models.Cave" lazy="false"></many-to-one>
		<bag name="beehives" table="BEAR_BEEHIVE" lazy="false">
			<key>
				<column name="BEAR_ID" not-null="true"></column>
			</key>
			<many-to-many entity-name="com.revature.models.Beehive">
				<column name="BEEHIVE_ID" not-null="true"></column>
			</many-to-many>
		</bag>
	</class>

</hibernate-mapping>
```

- we can also include this configuration right into our Java classes using annotations
- below is the equivalent mapping with annotations

```java
@Entity
public class Bear implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bear_id")
	private int id;
	
	@Column(name="bear_name")
	private String name;

	@ManyToOne
	@JoinColumn(name="cave_id")
	private Cave cave;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="bear_beehive",
			joinColumns={@JoinColumn(name="bear_id")},
			inverseJoinColumns={@JoinColumn(name="beehive_id")})
	private List<Beehive> beehives = new ArrayList<>();

    // other source code
```

- @Entity annotates a class indicating that it will be mapped to a table
- by default the table name will be the class name. however; if you include @Table along with @Entity, you can give it a different name
- every field in the class will be mapped to a column; the only exception is if a field is marked with @Transient
- the @Column annotation is used to define the column name as something other than the field name
- @Id is required to define the field which represents the primary key in the table
- we can use @GeneratedValue do define an auto-incrementing primary key
- we also have entities which have foreign key relationships which need to be represented in our database. For these, we have a specific set of annotations
    - @OneToOne
    - @ManyToOne
        - with many to one relationships, we would be storing the reference in the many side - so in the table you're currently defining
        - declaring a many to one relationship will define a join column referencing the primary key of the object in the field the annotation is over (provided that object is mapped with hibernate as well)
        - we can describe this join column further with the @JoinColumn annotation
    - @OneToMany
        - with one to many relationships, we would be storing the reference in the many side - so it would be defined by the other entity
    - @ManyToMany
        - many to many relationships are not stored in either of the related  
        - using this annotation creates a join table for the two entities
        - the join table can be explicitly defined using @JoinTable

## Hibernate Persistent States

### Transient
- object exists on the java side but there isn't a representation in the database that's being managed by a session

### Persistent
- there is an object managed by a session

### Detached
- was once managed by a session but the session has been closed

Example: 

``` java 
    Session s = HibernateUtil.getSession(); // create a session; HibernateUtil is pre-implemented
    Bear b = new Bear(); // b is in the transient state
    s.save(b); // b now becomes persistent 
    s.close(); // the session is now closed and b enters the detached state

```

## Session Methods
#### get 
- retrieves a single object from the database
- eagerly fetches data, querying the database when it's called 
- If an object is attempted to be retrieved with an id not in the database, get will return null

#### load
- Retrieves a proxy object representing a single object from the database
- A proxy is an anonymous subclass which contains the same id as the requested resource. Keep in mind that we can refer to any subclass as it's superclass so it may not seem like the proxy is any different. (```Bear b = s.load(3, Bear.class)``` represents ```Bear obj = new [Bear Proxy]```. We know this is valid because ```SuperClass obj = new Subclass()``` is valid.)
- the proxy acts as a placeholder for your value. Once you make a request for any information other than the id, at that time Hibernate will load in the data to your proxy object and it can function like a normal object.
- If you don't access any data before the session is closed, you may not access the object as it never becomes more than just the proxy object. A LazyInitializationException is thrown if one attempts to access a proxy after the session is closed.
- The load method will also throw an exception if a record is requested with an id not present in the database.

#### Query Interface 
- Using the Query interface we can query for a set of data rather than just one object.
- There are several methods we can use that will create implementations of the Query interface.
1. .createQuery(String)
    - the string in this case takes in something called HQL
    > HQL is Hibernate Query Language. It is an object oriented version of SQL. It allows you to write in a syntax similar to SQL but using class and field names rather than table and column names.
    > Ex. you change a column name or modify your table - with JDBC we need to update every reference to that table or those columns; with HQL, we don't have to change our code at all, we just need to modify our mappings once and every HQL query would be properly configured.
    > SQL "select * from employee" -> HQL "from Employee"
    > (more on HQL here)**********
2. .getNamedQuery(String)
    - if you intend to use an HQL statement again and again, you can save this HQL as a named query (this is similar to our previous idea of a view in SQL but on the java side)
    - the string parameter here represents the name we assign to identify the query
    - named queries can be declared with a @NamedQueries annotation or with a `<query>` tag in an hbm file

    ``` xml
    <query name="getBearsByName">
        <![CDATA[from Bear where name = :nameVar]]>
    </query>
    ```

    ```java
    @NamedQueries({ @NamedQuery(name="getBearByName", query="from Bear where name = :nameVar")})
    ```
3. .createQuery(CriteriaQuery)
    - While HQL aims to make our SQL queries more programmatic, CriteriaQuery takes this even further. CriteriaQuery uses the builder pattern********** to programmatically construct a typ safe query.
    - The goal of CriteriaQuery is to remove the possible mistakes from malformed SQL strings, as there is no type safety or compile time error checking associated with them. 
4. .createNativeQuery(String)
    - the string parameter here is represented by plain sql like we're used to
    - it is not preferred as it is dialect specific - it also doesn't allow us to take advantage of the object mapping

#### persist
- attempts to make a transient object persistent 
- void return type 
- doesn't assure primary key until flush time - when db records synchronize with the state of our java objects (this occurs before some query executions and when a transaction is committed)
- throws an exception if the method is called on a detached object (object already in the db but not attached to the session)

#### save
- attempts to make a transient or detached object persistent
- returns id, assures immediate access of PK if it's generated

#### update
- attempts to make a detached object persistent
- void return type
- will throw a NonUniqueObjectException if there is already a persistent object in the current session with the same identifier
- throws an exception if an object is provided with an identifier that isn't in the database

#### merge
- if there is already a persistent object in the current context, the object provided will be merged with that persistent object
- returns that merged object

#### saveOrUpdate
- saves the object if the identifier isn't in the database, performs an update if the identifier is

## Transactions
- We can also create transactions in Hibernate using our Session object
- It is good practice to wrap our db operations in explicit transactions

```java
    Transaction tx = s.beginTransaction();
    // perform operation(s) on our db
	tx.commit();
```

## Caching
### First Leveling Caching
- default caching level
- session scoped
- data for an operation is cached locally, if the same operation is made within the same session without the session being flushed () then the request will not be made again but rather the cached data will be returned instead
## Second Level Caching
- cannot be set unless a third party caching library (e.g. ehcache) is configured 
- session factory scoped