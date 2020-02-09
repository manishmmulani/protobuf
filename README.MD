Two things required

- Proto compiler -> protoc binary that compiles .proto file into .java file (or any required language specific)
https://github.com/protocolbuffers/protobuf/releases/download/v3.11.3/protoc-3.11.3-linux-x86_64.zip

- Proto runtime -> 
Gradle dependency    compile 'com.google.protobuf:protobuf-java:3.11.0'


### Step 1 : 
Write a .proto file 
https://github.com/protocolbuffers/protobuf/blob/master/examples/addressbook.proto

### Step 2 : 
Compile .proto to java files 
protoc --java_out={DIRECTORY_FOR_JAVA_OUTPUT_FILES} addressbook.proto
OR
protoc -I={SRC_DIR_CONTAINING_PROTO_FILES} --java_out={DIRECTORY_FOR_JAVA_OUTPUT_FILES}
The above generates com/example/tutorial/AddressBookProtos.java in output directory i.e java

### Step 3 : 

https://developers.google.com/protocol-buffers/docs/javatutorial

