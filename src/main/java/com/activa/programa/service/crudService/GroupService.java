package com.activa.programa.service.crudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activa.programa.model.GroupModel;
import com.activa.programa.repository.IGroupRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    @Autowired
    private IGroupRepository groupRepository;

    public List<GroupModel> getAllGroup() {
        return groupRepository.findAll();
    }

    public GroupModel getGroupById(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

    public GroupModel createGroup(GroupModel group) {
        return groupRepository.save(group);
    }

    public GroupModel updateGroup(Long id, GroupModel groupDetails) {
        GroupModel group = groupRepository.findById(id).orElse(null);
        if (group == null) {
            return null;
        }
        return groupRepository.save(group);
    }

    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
