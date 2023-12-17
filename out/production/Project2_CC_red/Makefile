run: # runs the main entry point and compiles all teammate contributions
	javac Pokedex.java
	java Pokedex

runTests: runBackendDeveloperTests runDataWranglerTests runAlgorithmEngineerTests runFrontendDeveloperTests #runs all tests

runBackendDeveloperTests: backendTestDependencies # runs the JUnit tests for the BackendDeveloper
	javac -cp .:junit5.jar BackendDeveloperTests.java
	java -jar junit5.jar --scan-classpath -cp . -n BackendDeveloperTests

backendTestDependencies: # compiles necessary files for the backend tests
	javac IPokeBackend.java
	javac IPokeRBT.java
	javac IPokeValidator.java
	javac IPokemon.java
	javac PokeBackend.java
	javac BackendPlaceholderPokeRBT.java

runFrontendDeveloperTests: TextUITester.class FrontendDeveloperPokemonPlaceholder.class FrontendDeveloperPokeValidatorPlaceholder.class FrontendDeveloperPokeBackendPlaceholder.class PokeFrontend.class Frontend.class
	java -jar junit5.jar --scan-classpath -cp . -n FrontendDeveloperTests

Frontend.class: FrontendDeveloperTests.java
	javac -cp .:junit5.jar FrontendDeveloperTests.java

PokeFrontend.class: PokeFrontend.java
	javac PokeFrontend.java

# This runs all tests for the DataWrangler role
runDataWranglerTests: DataWranglerTests.class IPokemon.class Pokemon.class IPokeLoader.class PokeLoader.class
	java -jar junit5.jar --class-path=. --include-classname=.* --select-class=DataWranglerTests

DataWranglerTests.class: DataWranglerTests.java
	javac -cp .:junit5.jar DataWranglerTests.java

IPokemon.class: IPokemon.java
	javac IPokemon.java

IPokeLoader.class: IPokeLoader.java
	javac IPokeLoader.java

Pokemon.class: Pokemon.java
	javac Pokemon.java

PokeLoader.class: PokeLoader.java
	javac PokeLoader.java

# This runs all tests for the AlgorithmEngineer role
runAlgorithmEngineerTests: IPokeRBT.class AlgorithmEngineerTests.class AEPokemonForTests.class AEIPokeValidator.class
	javac -cp .:junit5.jar AlgorithmEngineerTests.java
	java -jar junit5.jar --scan-classpath -cp . -n AlgorithmEngineerTests

AlgorithmEngineerTests.class: AlgorithmEngineerTests.java
	javac -cp .:junit5.jar AlgorithmEngineerTests.java

IPokeRBT.class: IPokeRBT.java
	javac IPokeRBT.java

AEPokemonForTests.class: AEPokemonForTests.java
	javac AEPokemonForTests.java

AEIPokeValidator.class: AEIPokeValidator.java
	javac AEIPokeValidator.java

clean: # removes all class files if there are any
	rm *.class

TextUITester.class: TextUITester.java
	javac TextUITester.java

FrontendDeveloperPokeBackendPlaceholder.class: FrontendDeveloperPokeBackendPlaceholder.java
	javac FrontendDeveloperPokeBackendPlaceholder.java

FrontendDeveloperPokeValidatorPlaceholder.class: FrontendDeveloperPokeValidatorPlaceholder.java
	javac FrontendDeveloperPokeValidatorPlaceholder.java

FrontendDeveloperPokemonPlaceholder.class: FrontendDeveloperPokemonPlaceholder.java
	javac FrontendDeveloperPokemonPlaceholder.java
