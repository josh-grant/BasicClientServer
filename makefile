default:
	javac ./src/BasicClient.java -d ./bin/
	javac ./src/BasicServer.java -d ./bin/

Client:
	javac ./src/BasicClient.java -d ./bin/

Server:
	javac ./src/BasicServer.java -d ./bin/

clean:
	rm ./bin/*.class
	rm ./javac_build_log.txt
