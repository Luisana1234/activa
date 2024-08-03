package com.activa.programa.controller.crudController;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activa.programa.model.GroupModel;
import com.activa.programa.service.crudService.GroupService;


@Controller
@RequestMapping("/api/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @GetMapping("/addGroup")
    public String showaaddGroup() {
        return "admin/addFormulary/addGroup";
    }


    @GetMapping()
    public String getAllGroups(Model model) {
        List<GroupModel> groups = groupService.getAllGroup();
        model.addAttribute("groups", groups);
        return "admin/Group";
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupModel> getGroupById(@PathVariable("id") Long id) {
        GroupModel group = groupService.getGroupById(id);
        if (group == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<GroupModel> createGroup(@RequestBody GroupModel group) {
        GroupModel createdGroup = groupService.createGroup(group);
        return new ResponseEntity<>(createdGroup, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupModel> updateGroup(@PathVariable("id") Long id, @RequestBody GroupModel group) {
        GroupModel updatedGroup = groupService.updateGroup(id, group);
        if (updatedGroup == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedGroup, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteGroup(@PathVariable("id") Long id) {
        groupService.deleteGroup(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
