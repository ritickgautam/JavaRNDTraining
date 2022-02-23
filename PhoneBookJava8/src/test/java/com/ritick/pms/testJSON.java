package com.ritick.pms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class testJSON {
	public static void main(String[] args) {
		JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("data/login.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray userList = (JSONArray) obj;

            System.out.println("For deleting a contact you need to be admin"
            		+ "\nPlease enter you admin id and password");
            String username = "john123";
            String password = "john123";

//            userList.stream().forEach(System.out::println);

//            for (Object object2 : userList) {
//				System.out.println(object2);
//			}


            JSONObject obj1 = (JSONObject) userList.get(0);
            System.out.println(obj1.get("firstName"));



            System.out.println(userList.stream().filter(object -> ((JSONObject) object).get("loginName").equals(username)).findAny().orElse(null));

//            for (Object object : userList) {
//            	System.out.println(((User) object).getLoginName());
//
//			}

            //check for id password and role = admin
            if(userList.stream().filter(object -> ((JSONObject) object).get("loginName").equals(username) && ((JSONObject) object).get("password").equals(password) && ((JSONObject) object).get("role").equals("admin")).findAny().orElse(null)!=null)
            {
            	System.out.println("Enter id you want to deleted : ");
            	int id = 11;
            	System.out.println("11 deleted");
            }
            else
            	System.out.println("Invalid credentials!!!");

//            System.out.println(userList);
//            System.out.println(userList.get(0));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

	}

}
