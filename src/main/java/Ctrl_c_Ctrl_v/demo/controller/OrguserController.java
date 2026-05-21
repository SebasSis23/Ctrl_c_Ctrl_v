package Ctrl_c_Ctrl_v.demo.controller;

import Ctrl_c_Ctrl_v.demo.model.Orguser;
import Ctrl_c_Ctrl_v.demo.service.OrguserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orguser")
@CrossOrigin(origins = "*")
public class OrguserController {

    @Autowired
    private OrguserService orguserService;

    @GetMapping
    public List<Orguser> getOrguser() {
        return orguserService.getAllOrguser();
    }

    @PostMapping
    public ResponseEntity<Orguser> createOrguser(@RequestBody Orguser orguser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orguserService.saveOrguser(orguser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orguser> getOrguserById(@PathVariable String id) {
        return orguserService.getOrguserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orguser> updateOrguser(@PathVariable String id, @RequestBody Orguser orguser) {
        return orguserService.updateOrguser(id, orguser)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrguser(@PathVariable String id) {
        if (!orguserService.deleteOrguser(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
