package Ctrl_c_Ctrl_v.demo.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orguser")
public class OrguserController {

    @GetMapping
    public String prueba() {
        return "Orguser funcionando";
    }
}