package com.example.cadastroartigos.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.cadastroartigos.models.entities.Artigo;
import com.example.cadastroartigos.models.entities.Usuario;
import com.example.cadastroartigos.models.repository.ArtigoRepositorio;

@RestController
@RequestMapping("/api/artigo")
public class ArtigoController {
	
	@Autowired
	private ArtigoRepositorio artigoRepositorio;
	
	@PostMapping
	public @ResponseBody Artigo salvarArtigo(@Validated Artigo artigo) {
		artigoRepositorio.save(artigo);
		return artigo;
	}
	
	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "F://temp//";

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
	
	@GetMapping
	public Iterable<Artigo> obterArtigo(){
		return artigoRepositorio.findAll();
	}
	
	@DeleteMapping(path = "/{id}")
	public void excluirArtigo(@PathVariable int id) {
		artigoRepositorio.deleteById(id);
	}

	

}
