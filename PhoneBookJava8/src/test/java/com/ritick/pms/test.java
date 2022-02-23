package com.ritick.pms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ritick.pms.model.phoneBook;

public class test {
	public static void main(String[] args) {
		List<phoneBook> pbList = new ArrayList<>();
		phoneBook pb1 = new phoneBook(11, 987625419, "Ritick", LocalDate.of(2000, 06, 24));
		phoneBook pb2 = new phoneBook(12, 987626419, "Abhishek", LocalDate.of(2000, 8, 20));
		phoneBook pb3 = new phoneBook(13, 987627419, "Anuj", LocalDate.of(2001, 9, 01));

		pbList.add(pb3);
		pbList.add(pb2);
		pbList.add(pb1);



		System.out.println("Show phonebooks");

		for (phoneBook phoneBook : pbList) {
			System.out.println(phoneBook.getName());
		}

		pbList.stream().forEach(System.out::println);

		System.out.println("find by id == 11");
		phoneBook p1 = pbList.stream().filter(pb -> 11==pb.getId()).findAny().orElse(null);
		System.out.println(p1.getName());

		System.out.println("Delete phone book id 11");
		pbList = pbList.stream().filter(i->i.getId()!=11).collect(Collectors.toList());
		System.out.println("updated list");
		pbList.stream().forEach(System.out::println);

	}

}
