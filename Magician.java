package com.revature.character;
import java.util.Objects;

public class Magician  extends Human implements Interface{
	
	private int level;
	private String name;
	
	private double health;
	private int mana;
	private int strength;
	private int defense;
	private int magic;

	public Magician(String name, int level) {
		this.name = name;
		this.level = level;
		
		this.mana = 2*level+50;
		this.health = 4*level + 25;
		this.strength = 1*level;
		this.defense = (int) (1.7*level);
		this.magic = 4*level;
	}

	//returns information about the character
	public String toString() {
		return "Name: "+name+" Level: "+level+
				"\nHP: "+health+" MP: "+mana+" STR: "+strength+" DEF: "+defense+" MAG: "+magic;
	}

	public String getName() {
		return this.name;
	}
	
	//prints a string where the character introduces itself
	public void speak() {
		if(health > 0) {
			super.speak();
			System.out.println("My name is "+name);
		}
		else {
			System.out.println(name+" does not say anything");
		}
	}
	
	//health is reduced by the difference between a number and the character's defense
	public void takeDamage(int num) {
		int damage = num - defense;
		if (damage>0) {
			this.health -= damage;
			System.out.println(name+" took "+damage+" damage.");
		}
		else {
			System.out.println(name+" took no damage.");
		}
		
		if(this.health<0) {
			this.health = 0;
			System.out.println(name+" has been defeated.");
		}
	}
	
	//returns whether or not the character is still alive 
	public boolean isAlive() {
		return(health>0);
	}
	
	//returns the characters strength, but reduces health by 10 percent
	//character cannot attack if they're not alive
	public int physicalAttack() throws Exception {
		if(health>0) {
			this.health -= this.health*0.1;
			return strength;
		}
		else {
			throw new Exception(name+" is dead and cannot attack.");
		}
	}
	
	//if this character has enough mana, return magic
	//if the character doesn't have enough mana but more than 0
	//the character will use up their remaining mana but the attack will be weaker
	//character cannot attack if they're not alive
	public int magicalAttack() throws Exception {
		if(mana >= 30 && health>0) {
			this.mana -= 30;
			return magic;
		}
		else if(mana < 30 && mana >0 && health>0){
			this.mana = 0;
			return magic/2;
		}
		else if(health>0) {
			System.out.println("Not enough MP!");
			return 0;
		}
		else {
			throw new NotAliveException(name+" is dead and cannot attack.");
		}
	}
	
	public boolean equals(Object o) { 
		    
		if(o == this) {
			return true;
		}
		
        if (o == null) { 
            return false; 
        }
        if (!(o instanceof Magician)) {
            return false;
        }
        
        Magician other = (Magician) o;
        if (!this.name.equals(other.name) || this.level != other.level) {
        	return false;
        }
		return true;
	}
	
	public int hashCode() {
        return Objects.hash(name, level, health, mana, strength, defense, magic);
    }
}
