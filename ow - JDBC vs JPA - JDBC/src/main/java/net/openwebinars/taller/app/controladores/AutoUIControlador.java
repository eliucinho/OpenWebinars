package net.openwebinars.taller.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.openwebinars.taller.app.modelos.Auto;
import net.openwebinars.taller.app.servicios.AutoServicio;

@Controller
public class AutoUIControlador {

    @Autowired
    private AutoServicio servicio;

    @RequestMapping("/")
    public String index(Model model) {
        setParametro(model, "lista", servicio.getTodos());
        return "index";
    }

    @GetMapping("/crear")
    public String irCrear(Model model) {
        setParametro(model, "auto", new Auto());
        return "formulario";
    }

    @GetMapping("/actualizar/{id}")
    public String irActualizar(@PathVariable("id") Long id, Model model) {
        setParametro(model, "auto", servicio.getValor(id));
        return "formularioActualizar";
    }

    @PostMapping("/guardar")
    public String guardar(Auto entity, Model model) {
        servicio.guardar(entity);
        return "redirect:/";
    }

    @PostMapping("/actualizar")
    public String actualizar(Auto entity, Model model) {
        servicio.guardar(entity);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, Model model) {
        servicio.eliminar(id);
        return "redirect:/";
    }

    public void setParametro(Model model, String atributo, Object valor) {
        model.addAttribute(atributo, valor);
    }

}
