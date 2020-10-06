package com.codeclan.example.filesservice.repositories;

import com.codeclan.example.filesservice.models.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder,Long> {
}
