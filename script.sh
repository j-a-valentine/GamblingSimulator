#!/bin/bash

javac -d bin src/simulator/*.java
	
java -cp bin simulator.Main