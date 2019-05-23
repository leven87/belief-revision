antlr4 = java -jar /usr/local/lib/antlr-4.7-complete.jar
SRCFILES = src.main.java
GENERATED = simpleListener.java simpleBaseListener.java simpleParser.java simpleBaseVisitor.java simpleVisitor.java simpleLexer.java

all:
	make src.main.class

src.main.class:	$(SRCFILES) $(GENERATED) Grammar.g4
	javac  $(SRCFILES) $(GENERATED)

simpleListener.java:	Grammar.g4
	$(antlr4) -visitor Grammar.g4

test:	src.main.class
	java src.main input.txt
