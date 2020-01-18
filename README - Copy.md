# Welcome

The software associated with the ***Wind Power Explorer*** is located in this the [https://github.com/WindPowerExplorer/FullSail](https://github.com/WindPowerExplorer/FullSail "FullSail") repository. This repository also depends on components developed in the [https://github.com/DonaldET/DemoDev/](https://github.com/DonaldET/DemoDev/ "DemoDev") repository. This software aids in planning a Wind Farm, which is a collection of Wind Generators placed in fixed positions on a rectangular grid of (nearly) flat land, or over the ocean. We are interested in understanding the power generation characteristics of a wind farm.

#### Background of Need

Because there are large capital investments required to create a wind farm, and significant regulatory compliance issues, it is important to optimize power output for a given investment. Investors must be assured of the eventual payoff for investing in the wind farm. These goals are achieved with good data about predicted power generation.

These *FullSail* projects help planners evaluate the prospective power output of a Wind Farm. A *Wind Farm* is a collection of *Wind Generators* that output saleable electrical power of a long period of time. The power output of this collection of wind generators varies depending on:

- wind characteristics,
- generator characteristics,
- topography,
- and individual generator placement. 

Unfortunately, data for validating the economics of a particular wind farm site are difficult to obtain. Since complete wind characteristics are often unavailable, and the Engineering models of wind power generation are often complicated, it is difficult to perform an accurate power analysis. Most of detailed engineering analyses are compute-intensive, and solved on a single machine, so large time periods (e.g., a year) are not typically simulated. One is forced to reason about Wind Farm power output over a long period of capitalization by using short time period simulations and hoping the results are representative of the time period under study.

#### The *FullSail* Approach

FullSail applies "Big Data" concepts and TBD.

#### FullSail Simulation Capabilities

TBD.

#### Repository Contents

Algorithms and performance testing approaches are included in the repository, as well as ready-to-use utility programs and libraries. There is a DevOps sub-project collection of projects using some of the utilities.

#### Building Projects in the Repository

The Java projects in *FullSail* use Maven to build and JUnit to test artifacts. Note that JUnit is a framework, one of many, for regression testing.  A Maven build project is defined by an XML structure persisted in a "***pom.xml***" file located in the build project directory. Maven build projects may be nested in a tree structure.

In a *tree* of Maven build projects, the _root_ (top-most) parent build project defines common MAVEN dependencies and version definitions in a *pom.xml*. Nested child build projects are located under the top-level parent build project, each child with their own *pom.xml* file, optionally overriding inherited MAVEN dependencies and versions.

A child build project build may, in turn, be a parent of an even lower level child build project, thus forming a multi-level tree of related build projects, each inheriting common MAVEN dependencies.

Maven creates a build using "*plugins*" that implement build actions. Similar to dependencies and versions, plugins are included in parent build projects and optionally overridden in child build projects.

There are far too many Maven tutorials to mention here, so please search the web for one that helps you. More information is provided in the **Getting Started** section below.

#### Java Requirement

Most of *FullSail* is built using Java 8, but Java 9 introduced the REPL (Run-Execute-Print-Loop); an interactive Java runtime environment. Many of us are still tied to Java 8 for business reasons, but would like to experiment with the REPL. This site, https://github.com/javaterminal/tryjshell, offers a browser-accessible version of the REPL. They provide a hosted version at https://tryjshell.org/.

#### *FullSail* Content Commercial Opportunities

Please contact _Donald Trummell_ via Email using dtrummell@gmail.com for additional information regarding commercial use of projects in this repository.  His LinkedIn profile is found at [http://www.linkedin.com/in/donaldtrummell/](http://www.linkedin.com/in/donaldtrummell/ "here"). You may review the published form of this documentation at the "pretty view" [http://donaldet.github.io/FullSail/](http://donaldet.github.io/FullSail/).

# Getting Started

All the information needed to build these projects is detailed in the _BuildResources_ document described below.  The process you will follow is:
 1. Download required build dependencies (e.g., Java, MAVEN, and optionally ANT)
 2. Install and test the build dependencies
 3. Fork or download the source code from the GitHub repository (see [http://www.github.com/DonaldET/FullSail/](http://www.github.com/DonaldET/FullSail/ "the source repo"))
 4. On the command line, from the downloaded base directory, execute:
    _mvn clean install_

The _StaticResources_ directory references instructions on how to setup a MAVEN and JAVA build environment in document _BuildResources.pdf_. It is a **GITHUB** hosted document that also contains links back to this source code repository (*FullSail*).## Build Information
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

**TBD**