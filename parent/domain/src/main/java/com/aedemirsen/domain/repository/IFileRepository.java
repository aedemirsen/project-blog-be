package com.aedemirsen.domain.repository;

import com.aedemirsen.domain.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IFileRepository extends JpaRepository<File, Long> {

//    @Query(
//            "select f from File f " +
//                    "inner join User u on u.profilePictureFile.id= f.id " +
//                    "where u.uuid= :uuid"
//    )
//    File findFileByUserUuid(@Param("uuid") UUID uuid);

}
