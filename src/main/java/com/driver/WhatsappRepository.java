package com.driver;

import java.util.HashMap;
import java.util.List;

public class WhatsappRepository {
    private int groupCount=0;
    HashMap<String,User> userMap = new HashMap<>();

    HashMap<Group,List<User>> groupHashMap = new HashMap<>();

    public String  createUser(String  name, String mobile) throws Exception {

        if(userMap.containsKey(mobile)){
            throw new Exception("user is already there");
        }
        User user = new User(name, mobile);
          userMap.put(mobile,user);
          return "SUCCESS";
    }

    public Group  createGroup(List<User> users){
        // The list contains at least 2 users where the first user is the admin. A group has exactly one admin.
        // If there are only 2 users, the group is a personal chat and the group name should be kept as the name of the second user(other than admin)
        // If there are 2+ users, the name of group should be "Group count". For example, the name of first group would be "Group 1", second would be "Group 2" and so on.
        // Note that a personal chat is not considered a group and the count is not updated for personal chats.
        // If group is successfully created, return group.

        //For example: Consider userList1 = {Alex, Bob, Charlie}, userList2 = {Dan, Evan}, userList3 = {Felix, Graham, Hugh}.
        //If createGroup is called for these userLists in the same order, their group names would be "Group 1", "Evan", and "Group 2" respectively.


        if(users.size()==2){
            Group group=new Group(users.get(1).getName(),2);
            groupHashMap.put(group,users);
            return group;
        }
        Group group=new Group("Group "+ ++groupCount,users.size());
        groupHashMap.put(group,users);
        return group;
    }
}
