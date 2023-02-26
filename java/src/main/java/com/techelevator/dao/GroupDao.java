package com.techelevator.dao;

import com.techelevator.model.Group;
import com.techelevator.model.GroupMember;

import java.util.List;

public interface GroupDao {

    void createGroup(Group group, String username);

    void deleteGroup(int groupId);

    void editGroup(Group group);

    Group getGroupById(int groupId);

    List<Group> getAllGroups();

    void addUserToGroup(GroupMember groupMember);

    List<GroupMember> getAllMembers(int groupId);
    // returns 0 if member is not in group and 1 if member is in group. This is a work around for the truthiness that JS has.
    int isMemberInGroupByUsername(int groupId, String username);

    void removeUserFromGroup(int userId, int groupId);

    String getGroupCreatedDate(int groupId, int groupOwnerId);

//    String getGroupCreatedDate(int groupId, int groupOwnerId);

}
