import com.example.tutorial.AddressBookProtos.Person
import com.example.tutorial.AddressBookProtos.AddressBook
import java.io.FileInputStream

import java.io.FileOutputStream

// AddressBookProtos is auto-generated using protoc
fun initAddressBook(): AddressBook {
    val addressBookBuilder = AddressBook.newBuilder()
    return addressBookBuilder.addAllPeople(
        IntRange(1, 10).map { it ->
            Person.newBuilder().setId(it).setName("Person$it").setEmail("person$it@email.com").build()
        }
    ).build()
}

fun writeAddressBookToFile(addressBook: AddressBook, file: String) {
    val fileOut = FileOutputStream(file)
    addressBook.writeTo(fileOut)
    fileOut.close()
}

fun printAddressBook(addressBook: AddressBook) {
    for (person in addressBook.peopleList) {
        println(person)
    }
}

fun readAddressBookFromFile(file:String):AddressBook {
    return AddressBook.parseFrom(FileInputStream(file))
}

fun main(args:Array<String>) {
    val addressBook = initAddressBook()
    val fileName = "build/tmp/addressbook.out"
    writeAddressBookToFile(addressBook, fileName)
    val readAddressBook = readAddressBookFromFile(fileName)
    printAddressBook(readAddressBook)
}