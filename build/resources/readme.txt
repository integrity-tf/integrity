The Integrity build consists of 5 bundles:

de.gebit.integrity.dsl         - The main classes of the domain specific language
de.gebit.integrity.dsl.ui      - The editor customizations for the Eclipse-integrated, Xtext-based editor
de.gebit.integrity.eclipse     - The Test Runner Eclipse plugin (for controlling external Test Runner instances)
de.gebit.integrity.remoting    - The Test Runner remote control protocol
de.gebit.integrity.runner      - The Test Runner


In order to integrate Integrity into Eclipse, the Eclipse installation requires an installed Xtext (>= 2.1.1) and the
following Integrity bundles:
 - de.gebit.integrity.dsl
 - de.gebit.integrity.dsl.ui
 - de.gebit.integrity.eclipse
 - de.gebit.integrity.remoting
 
(You could leave out the latter two if the Test Runner control plugin is not desired)


A System Under Test has to get the Integrity dependencies (copied into the platform directory during build) as well as
the following Integrity bundles:
 - de.gebit.integrity.dsl
 - de.gebit.integrity.remoting
 - de.gebit.integrity.runner