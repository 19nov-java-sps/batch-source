# Docker 
- platform for developers to develop, deploy, and run applications with containers
- Docker can only be used on Linux machines (Docker Toolbox can be used to configure Docker on a Mac or Windows Pro)

## Containerization
### Virtual Machines vs Containers
- both ways we can have partition a single machine into multiple computing environments
- virtual machines each have their own OS that are integrated with the host machines host operating system with a hypervisor
- containers have the ability to share a an operating system while maintaining their own isolated computing environment
    - can have their own file systems, environment variables, etc. 
- the hypervisor is not necessary, the guest OS are not necessary
- much more lightweight more easily scalable
- more efficient use of machine's resources


<img src="https://www.brightcomputing.com/hs-fs/hubfs/Blog_Images/containers-vm.jpg?width=960&height=470&name=containers-vm.jpg" alt="containers v. vms">

Containers are:
- Flexible: Even the most complex applications can be containerized.
- Lightweight: Containers leverage and share the host kernel.
- Interchangeable: You can deploy updates and upgrades on-the-fly.
- Portable: You can build locally, deploy to the cloud, and run anywhere.
- Scalable: You can increase and automatically distribute container replicas.
- Stackable: You can stack services vertically and on-the-fly.

### Drawbacks of Containerization
- don't have the flexibility of using different operating systems for different applications ("OS lock in"); we can provide software which makes applications compatible with other OS but no longer have the benefit of them being as lightweight 
- if an OS is comprimised it effects all applications

## Docker Workflow
- image: the basis of a container 
    - an ordered collection of root filesystem changes and the corresponding execution parameters for use within a container runtime

- two ways we can obtain an image
    1. we can build our image with a Dockerfile
    2. we can pull our image from DockerHub
- once we have an image we can create a container in that image

### Dockerfile
- A file which describes the the changes we're making on the environment to make our image
    - base image: an image created with a Dockerfile with no FROM 
    - parent image: an image in the FROM clause

Dockerfile keywords:
- FROM: specifies the parent image, the image upon which your image is build on
    - if you don't include the FROM keyword, you're creating base image
- ADD: can do what copy does but can also use a URL 
- COPY: copies a file or directory from the host to the container
- ENV: set environment variables 
- EXPOSE: documents the port to be exposed (is not actually enforced, doesn't actually do anything)
- LABEL: allows you to set key value pairs of metadata
- WORKDIR: changes the working director from which changes are being made
- RUN: runs a shell command, or runs an executable

Building an Image with a Dockerfile 
- this is done with the CLI build command, where the only required argument is the location of the Dockerfile
    - docker build .
    - docker build -t [tagname] .

### DockerHub
- centralized library for container images
- images available from software vendors, can add your own repositories

## Docker Compose 
- a tool for defining and running multi-container Docker applications
- docker-compose.yml file allows you to configure your applications' services so that you can spin up all of your containers at once

## Docker Swarm
- docker has a swarm mode in which you can create and manage clusters of docker containers
- a swarm contains multiple instances of docker engines prepared to handle tasks
- each docker engine in the swarm is considered a node
- nodes can be a manager with the ability to delegate tasks and/or a worker a node which runs tasks
- managers delegate these tasks via docker services
- when the manager creates or scales these services, the tasks associated with them are automatically distributed an redistributed among the nodes in the swarm