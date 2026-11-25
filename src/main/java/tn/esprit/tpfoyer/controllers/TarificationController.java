package tn.esprit.tpfoyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.services.TarificationService;

@RestController
@RequiredArgsConstructor
public class TarificationController {

    private final TarificationService tarificationService;

    @GetMapping("/tarifs")
    public double calculer(@RequestParam("type") String type,
                           @RequestParam("tarifJournalier") double tarifJournalier,
                           @RequestParam("jours") int jours) {
        return tarificationService.calculer(type, tarifJournalier, jours);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String erreur(IllegalArgumentException e) {
        return e.getMessage();
    }
}