package com.matiaspakua.cashcard;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cashcards")
public class CashCardController {

	private CashCardRepository cashCardRepository;

	public CashCardController(CashCardRepository cashCardRepository) {
		this.cashCardRepository = cashCardRepository;

	}

	@GetMapping("/version")
	public String version() {
		return "0.1";
	}

	@GetMapping("/{requestedId}")
	public ResponseEntity<CashCard> findById(@PathVariable Long requestedId) {
		cashCardRepository.findAll();
		if (requestedId.equals(99L)) {
			CashCard cashCard = new CashCard(99L, 123.12);
			return ResponseEntity.ok(cashCard);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
