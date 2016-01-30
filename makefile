default:
	javac ./Client/src/BasicClient.java -d ./Client/bin
	javac ./Server/src/BasicServer.java -d ./Server/bin

client:
	javac ./Client/src/BasicClient.java -d ./Client/bin

Client:
	javac ./Client/src/BasicClient.java -d ./Client/bin

server:
	javac ./Server/src/BasicServer.java -d ./Server/bin

Server:
	javac ./Server/src/BasicServer.java -d ./Server/bin

clean:
	rm ./Client/bin/BasicClient.class
	rm ./Server/bin/BasicServer.class
