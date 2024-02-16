package org.example.unicodejpaopgave.repository;

import org.example.unicodejpaopgave.model.Unicode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnicodeRepository extends JpaRepository<Unicode, Integer> {
}
