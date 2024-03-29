# Welcome

The ***FullSail*** repository houses software associated with the ***Wind Power Explorer*** project hosted at [https://github.com/WindPowerExplorer/FullSail](https://github.com/WindPowerExplorer/FullSail "FullSail"). The code here also depends on components developed in the ***DemoDev*** repository hosted at [https://github.com/DonaldET/DemoDev/](https://github.com/DonaldET/DemoDev/ "DemoDev"). The *Wind Power Explorer* project, using domain and package name ***WPE***, aids in planning a Wind Farm, which is a collection of Wind Generators. Many Wind Generators (Wind Turbines) are placed in fixed positions on a rectangular grid of (nearly) flat land, or over the ocean. Wind Generators are mostly horizontal axis types. *WPE* are interested in understanding the power generation characteristics of a wind farm to inform investors and planners capitalizing the venture, what power generation potential is possible.

#### Description of *WPE* Contribution

Because large capital investments are required to create a wind farm, and there are significant regulatory compliance issues, it is important to optimize power output for a given investment. Investors must be assured of the eventual payoff for investing in the wind farm. These goals are achieved with good data about predicted power generation.

Our *FullSail* software helps planners evaluate the prospective power output of a Wind Farm. A *Wind Farm* is a collection of *Wind Generators* that output saleable electrical power over a long period of time. The power output of this collection of wind generators varies depending on:

- wind characteristics,
- wind generator characteristics,
- topography,
- and individual generator placement. 

Unfortunately, data for validating the economics of a particular wind farm site are difficult to obtain. Since complete wind characteristics are often unavailable, and the Engineering models of wind power generation are often complicated, it is difficult to perform an accurate power analysis. Most of detailed engineering analyses are compute-intensive, and solved on a single computer, so long time periods (e.g., a year) are not typically simulated. One is forced to reason about Wind Farm power output over a long period of capitalization by using short time period simulations and hoping the results are representative of the time period under study.

#### The *FullSail* Approach to Wind Farm Power Output Assessment

*FullSail* software applies "Big Data" and cloud-native application concepts to enable a robust simulation of wind characteristics and power generation, and many statistical summaries that enable an informed assessment of potential power generation offered by a particular Wind Farm. Applying these approaches allows a Wind Farm planner or investor to:

- Simulate a large variety of wind conditions and generator configurators to maximize power generation capabilities of a wind farm.
- Discover potential risks to power generation from extreme wind conditions.
- Assess the effect of generator failure.

*FullSail* software is able monitor wind conditions to detect operational and performance problems by using Apache Spark with DStreams and Apache Kafka.

#### FullSail Simulation Capabilities

*FullSail* is able to simulate both wind conditions and power generation characteristics through various algorithms that are "pluggable". That is, a user may select a more complex algorithm that enhances accuracy but requires greater computational resources. There is an easy mechanism to add custom simulations for both wind conditions and generators as well.

#### Repository Contents

Algorithms and performance testing approaches are included in the repository, as well as ready-to-use utility programs and libraries. There is a DevOps sub-project collection of projects using some of the utilities.

#### Building Projects in the *FullSail* Repository

The Java projects in *FullSail* use Maven to build and JUnit to test artifacts. Note that JUnit is a framework, one of many, for regression testing.  A Maven build project is defined by an XML structure persisted in a "***pom.xml***" file located in the build project directory. Maven build projects may be nested in a tree structure.

In a *tree* of Maven build projects, the _root_ (top-most) parent build project defines common MAVEN dependencies and version definitions in a *pom.xml*. Nested child build projects are located under the top-level parent build project, each child with their own *pom.xml* file, optionally overriding inherited MAVEN dependencies and versions.

A child build project build may, in turn, be a parent of an even lower level child build project, thus forming a multi-level tree of related build projects, each inheriting common MAVEN dependencies.

Maven creates a build using "*plugins*" that implement build actions. Similar to dependencies and versions, plugins are included in parent build projects and optionally overridden in child build projects.

There are far too many Maven tutorials to mention here, so please search the web for one that helps you. More information is provided in the **Getting Started** section below.

#### Java Requirement

Most of *FullSail* is built using Java 8, but Java 9 introduced the REPL (Run-Execute-Print-Loop); an interactive Java runtime environment. Many of us are still tied to Java 8 for business reasons, but would like to experiment with the REPL. This site, https://github.com/javaterminal/tryjshell, offers a browser-accessible version of the REPL. They provide a hosted version at https://tryjshell.org/.

#### *FullSail* Content Commercial Opportunities

Please contact _Donald Trummell_ via Email using dtrummell@gmail.com for additional information regarding commercial use of projects in this repository.  His LinkedIn profile is found at [http://www.linkedin.com/in/donaldtrummell/](http://www.linkedin.com/in/donaldtrummell/ "here"). You may review the published form of this documentation at the "pretty view" at [http://windpowerexplorer.github.io/FullSail/](http://windpowerexplorer.github.io/FullSail/ "here").

# Getting Started

All the information needed to build these projects is detailed in the _BuildResources_ document described below.  The process you will follow is:
 1. Download required build dependencies (e.g., Java, MAVEN, and optionally ANT)
 2. Install and test the build dependencies
 3. Fork or download the source code from the GitHub repository (see [http://www.github.com/DonaldET/FullSail/](http://www.github.com/DonaldET/FullSail/ "the source repo"))
 4. On the command line, from the downloaded base directory, execute:
    _mvn clean install_

The _StaticResources_ directory references instructions on how to setup a MAVEN and JAVA build environment in document _BuildResources.pdf_. It is a **GITHUB** hosted document that also contains links back to this source code repository (*FullSail*).

## Wind Power Description

A wind farm is a capital-intensive mechanism to generate large-scale electrical power from these major components.

###### Wind Generator (taken from [http://me1065.wikidot.com/types-of-wind-turbines-and-associated-advantages](http://me1065.wikidot.com/types-of-wind-turbines-and-associated-advantages).)

Horizontal axis wind turbines are the most common type used (see figure 1). All of the components (blades, shaft, generator) are on top of a tall tower, and the blades face into the wind. The shaft is horizontal to the ground. The wind hits the blades of the turbine that are connected to a shaft causing rotation. The shaft has a gear on the end which turns a generator. The generator produces electricity and sends the electricity into the power grid. The wind turbine also has some key elements that adds to efficiency. Inside the Nacelle (or head) is an anemometer, wind vane, and controller that read the speed and direction of the wind. As the wind changes direction, a motor (yaw motor) turns the nacelle so the blades are always facing the wind. The power source also comes with a safety feature. In case of extreme winds the turbine has a break that can slow the shaft speed. This is to inhibit any damage to the turbine in extreme conditions.

###### Turbine Wake

**TBD**## Build Information
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