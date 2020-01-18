# Welcome

These *FullSail* projects help evaluate the prospective power output of a Wind Farm. A *Wind Farm* has a collection of *Wind Generators* that output electrical power, which varies depending on wind characteristics and individual generator placement. Because there are large capital investments required to create a wind farm, and significant regulatory compliance issues, it is important to optimize power output for a given investment. Investors must be assured of the eventual payoff for investing in the farm. These goals are achieved with good data about predicted power generation.

Unfortunately, data for validating the economics of a particular wind farm site are difficult to obtain. Since complete wind characteristics are often unavailable, and the Engineering models of wind power generation are often complicated, it is difficult to perform an exact power analysis. Most of detailed engineering analyses are compute-intensive, and solved on a single machine, large time periods (e.g., a year) are not simulated.

#### The *FullSail* Approach

FullSail applies "Big Data" concepts and 

#### Repository Contents

Algorithms and performance testing approaches are included in the repository, as well as ready-to-use utility programs and libraries. There is a DevOps sub-project collection of projects using some of the utilities.

#### Building Projects in the Repository

The Java projects in *FullSail* use Maven to build and JUnit to test artifacts. Note that JUnit is a framework, one of many, for regression testing.  A Maven build project is defined by an XML structure persisted in a "***pom.xml***" file located in the build project directory. Maven build projects may be nested in a tree structure.

In a *tree* of Maven build projects, the _root_ (top-most) parent build project defines common MAVEN dependencies and version definitions in a *pom.xml*. Nested child build projects are located under the top-level parent build project, each child with their own *pom.xml* file, optionally overriding inherited MAVEN dependencies and versions.

A child build project build may, in turn, be a parent of an even lower level child build project, thus forming a multi-level tree of related build projects, each inheriting common MAVEN dependencies.

Maven creates a build using "*plugins*" that implement build actions. Similar to dependencies and versions, plugins are included in parent build projects and optionally overridden in child build projects.

There are far too many Maven tutorials to mention here, so please search the web for one that helps you. More information is provided in the **Getting Started** section below.

#### Java Requirement

Most of *DemoDev* is built using Java 8, but Java 9 introduced the REPL (Run-Execute-Print-Loop); an interactive Java runtime environment. Many of us are still tied to Java 8 for business reasons, but would like to experiment with the REPL. This site, https://github.com/javaterminal/tryjshell, offers a browser-accessible version of the REPL. They provide a hosted version at https://tryjshell.org/.

#### Java and Python Coding Practice, Data Management Free Resources 

Here are some educational web sites for testing your Java and Python coding skills:

- [https://www.hackerrank.com/](https://www.hackerrank.com/ "Hacker Rank"), test problems and competitive scoring.
- [https://leetcode.com/](https://leetcode.com/ "Leet Code"), presenting problems and solutions in a peer-reviewed development environment.
- [https://coderpad.io/](https://coderpad.io/ "Coder Pad"), a white-board development environment for coding exams.
- https://app.codility.com/demo/take-sample-test/, like coderpad, the codility web site is a testing environment offering practice problems.
- [https://www.pramp.com/#/](https://www.pramp.com/#/ "Pramp"), an interactive coding interview environment for practicing coding interviews.

Additional support for testing SQL programming, which is heavily used in Data Engineering, includes these sites that run MySQL sandboxes:
- SQL runner only: [https://paiza.io/projects/featured?language=mysql](https://paiza.io/projects/featured?language=mysql).
- SQL skills testing: [https://coderpad.io/demo](https://coderpad.io/demo) and the practice sandbox [https://coderpad.io/sandbox](https://coderpad.io/sandbox).

Finally, must of the Python content of this repository is concerned with *Apache Spark*, and a good free Spark implementation is hosted by Databricks (the community edition) found at  https://databricks.com/try-databricks.

#### *DemoDev* Content Commercial Opportunities

Please contact _Donald Trummell_ via Email using dtrummell@gmail.com for additional information regarding commercial use of projects in this repository.  His LinkedIn profile is found at [http://www.linkedin.com/in/donaldtrummell/](http://www.linkedin.com/in/donaldtrummell/ "here"). You may review the published form of this documentation at the "pretty view" [http://donaldet.github.io/DemoDev/](http://donaldet.github.io/DemoDev/).

# Getting Started

All the information needed to build these projects is detailed in the _BuildResources_ document described below.  The process you will follow is:
 1. Download required build dependencies (e.g., Java, MAVEN, and optionally ANT)
 2. Install and test the build dependencies
 3. Fork or download the source code from the GitHub repository (see [http://www.github.com/DonaldET/DemoDev/](http://www.github.com/DonaldET/DemoDev/ "the source repo"))
 4. On the command line, from the downloaded base directory, execute:
    _mvn clean install_

The _StaticResources_ directory references instructions on how to setup a MAVEN and JAVA build environment in document _BuildResources.pdf_. It is a **GITHUB** hosted document that also contains links back to this source code repository (*DemoDev*).

## *DemoDev* Sub-Project Categories

*DemoDev* is composed of multiple sub-projects, with each sub-project having a README.md file offering information about the sub-project and its contents.  Interesting sub-projects include:

- *algorithms*: Math algorithm demonstrations.
- *codingexams*: Coding and Algorithm interview questions asked over a whiteboard or in a collaboration environment coding environment.
- *hacks*: Unusual solutions to interesting problems that don't necessarily reflect _best practices_.
- *jerseyservices*: RESTful Java service implementations using the **Jersey framework**
- *memoryindexing*: In-memory search algorithms
- *utils*: Utilities used by _DemoDev_ and related projects (e.g., code generation used by _WindPower Explorer_)


## Sub-Project Structure

Sub-projects usually include a _business_ motivation for the coding examples in this section of the repository.  The examples also show good _OO design principals_, such as _KISS_, _DRY_ (don't repeat yourself), and _SOLID_ (Single responsibility, Open-closed, Liskov substitution, Interface segregation and Dependency inversion.) This site violates _YAGNI_ for educational purposes. Spring has a very readable overview of the *Liskov Substitution Principle* (see <https://springframework.guru/principles-of-object-oriented-design/liskov-substitution-principle/>.)

The sub-projects have their _JavaDoc_ entries explaining their role in the solution and the portion of the problem they address. Many sub-projects include JUnit tests because this reflects good _TDD_ practice and allows maintenance of the examples over time.  Stability over time is accomplished by using the regression aspect of these tests.

Many of the projects appear _complicated_ by use of the *Spring* framework to solve a potentially simple problem.  This is done to illustrate _Spring_ usage in addition to the basic techniques shown in the example. Overall, a professional Software Engineer would provide background for the code, some guidelines on usage in the _JavaDoc_ entries, and tips to help maintain the code.  The example invocations within unit tests help in achieving these documentation goals.

## Build Information
Naming and structural conventions, along with collected statistics on Maven build structure. Key Maven plugins are documented as well.

### Java Package Naming Conventions


TBD

### Maven Plugins

These Maven plugins are used in the build structure to achieve build tasks.

| Plugin                    | Description                                        | Link                                                    |
| :------------------------ | :------------------------------------------------- | :------------------------------------------------------ |
| *`maven-compiler-plugin`* | Defines Javac compiler source and runtime Java versions | https://maven.apache.org/plugins/maven-compiler-plugin/ |
| *`maven-resources-plugin`* | Copies source and test resources to output | https://maven.apache.org/plugins/maven-resources-plugin/ |
| *`maven-jar-plugin`* | Packages code and resources into a Jar with a Manifest | https://maven.apache.org/plugins/maven-jar-plugin/ |
| *`maven-surefire-plugin`* | Runs the application tests based on testing dependencies | https://maven.apache.org/surefire/maven-surefire-plugin/ |



### Detailed Build Statistics

**TBD**