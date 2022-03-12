default: jars

all: jars doc

jars: clseco agricole.jar clswar guerre.jar clsInputWar inputGuerre.jar clsInputEco inputAgricole.jar cleancls

agricole: clseco agricole.jar runagricole cleancls

guerre: clswar guerre.jar runguerre cleancls

inputAgricole : clsInputEco inputAgricole.jar runInputAgricole cleancls

inputGuerre : clsInputWar inputGuerre.jar runInputGuerre cleancls

cls:
		javac -classpath classes -sourcepath src src/boardgame/*.java -d classes

agricole.jar:
		jar cvfm jar/agricole.jar manifest-eco -C classes .

guerre.jar:
		jar cvfm jar/guerre.jar manifest-war -C classes .

inputAgricole.jar :
		jar cvfm jar/inputAgricole.jar manifest-inputEco -C classes .

inputGuerre.jar :
		jar cvfm jar/inputGuerre.jar manifest-inputWar -C classes .
	
doc:
		javadoc -sourcepath src -subpackages boardgame -d doc

clseco:
		javac -classpath classes -sourcepath src src/boardgame/EcoGameMain.java -d classes

clswar:
		javac -classpath classes -sourcepath src src/boardgame/WarGameMain.java -d classes

clsInputEco : 
		javac -classpath classes -sourcepath src src/boardgame/InputEcoGameMain.java -d classes

clsInputWar : 
		javac -classpath classes -sourcepath src src/boardgame/InputWarGameMain.java -d classes

runguerre:
		java -jar jar/guerre.jar Patrick Michel Alphonse Musclor Emmanuel

runagricole:
		java -jar jar/agricole.jar Ferdinand Gandhi Odette Maurice Philippe

runInputGuerre : 
		java -jar jar/inputGuerre.jar Patrick Michel Alphonse Gandhi Emmanuel

runInputAgricole : 
		java -jar jar/inputAgricole.jar Lucas Nestor Theo Alexandre

cleancls:
		rm -r classes/*

cleandoc:
		rm -r doc

cleanjars:
		rm jar/*.jar

clean: cleancls cleandoc

.PHONY: default all jars clean agricole guerre
