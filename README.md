# UI and REST Automation pipeline with Serenity, Selenium, Rest Assured, Jenkins pipelines and Docker
"Continuous delivery should be the cornerstone of your testing cycle. The advantages you can get from solid continuous integration are well known to software developers and quality assurance engineers. During last years, software delivery made a big step forward with a huge help of continuous delivery on all stages of a software development pipeline. Quality Assurance is not an exception and acceleration of QA pipeline helps to bring software much faster and with a better quality."

This is a simplest framework created for the article "Solid automation tests pipeline with Serenity, Selenium, Rest Assured, Taurus and Jenkins Blue ocean" to give you a well built launch pad that you can use to give life to your own automation pipeline. 
Mentioned article is concentrated on the continuous integration workflow itself, and it will provide you with everything you need to set up a whole QA automation pipeline with few technologies which you might find very useful for your needs. 


This project uses Junit for the test framework. Serenity as the backbone of the automation framework providing detailed reporting, parallel execution and test grouping by tags. REST Assured which is a useful framework for making REST API calls and tests. Selenium for UI automation tests and web browser interactions. Taurus provides a JMeter performance testing framework using yml scripts.

Reference: 
https://www.blazemeter.com/blog/qa-automation-pipeline-learn-how-to-build-your-own

###Prerequisites: 

 1. Java >= install Java 8 [Java 8 Download](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
 2. Apache Maven >= install Maven 3.0 [Maven 3.0 Download](https://maven.apache.org/install.html)
 3. Taurus >= install Taurus for performance testing [Taurus install instructions](https://gettaurus.org/?utm_source=blog&utm_medium=BM_blog&utm_campaign=qa-automation-pipeline-learn-how-to-build-your-own)

 4. IDE: Enable Annotations Processing in IntelliJ


Run group of tests by providing the maven parameter -Dtags:
 
 `mvn clean verify -Dtags="type:Smoke"`

`mvn clean verify -Dtags="type:API"`

`mvn clean verify -Dtags="type:UI"`


Running performance tests using the following specific command in the project's root folder:

`bzt src/test/java/performance/PerformanceTest.yml`




Dockerized Jenkins

Firstly, you will need to install Docker. Follow installation steps for docker here: [installation steps](https://docs.docker.com/engine/installation/).

Verify Docker is installed: `docker -v`

Setup and run Jenkins using just one command.
Runs a docker image the specified version of Jenkins

`docker run -p 8080:8080 -p 50000:50000 -v JENKINS_HOME:/var/jenkins_home \jenkins/jenkins:2.190.1 jenkins`

This command takes a Jenkins image from the cloud Docker repository, and then tails the logs of the running container. In the command above, `-p 8080:8080 -p 50000:50000` means that you want to forward ports from the Docker container outside, to be able to access the Jenkins app outside the Docker container.

As soon as the container is up and running, Jenkins will be available on the address http://localhost:8080/.

The administrator password can be found in the logs of your running Docker image or run the following to get the admin
                                                                                    password once it has finished starting
                                                                                    `docker exec jenkins-production bash -c 'cat $JENKINS_HOME/secrets/initialAdminPassword'`