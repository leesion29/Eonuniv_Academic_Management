package com.cw.cwu.repository;


import aj.org.objectweb.asm.commons.Remapper;
import com.cw.cwu.domain.Semester;
import com.cw.cwu.domain.SemesterTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.Optional;


public interface SemesterRepository extends JpaRepository<Semester, Integer> {


    @Query("SELECT s FROM Semester s WHERE :now BETWEEN s.startDate AND s.endDate")
    Optional<Semester> findCurrentSemester(LocalDate now);

    // 연도 + 학기 중복 방지를 위한 optional 조회
    boolean existsByYearAndTerm(Integer year, com.cw.cwu.domain.SemesterTerm term);

    Optional<Semester> findByStartDateBeforeAndEndDateAfter(LocalDate startDate, LocalDate endDate);

    // 오늘 이후 시작하는 학기 중 가장 빠른 학기 조회
    Optional<Semester> findFirstByStartDateAfterOrderByStartDateAsc(LocalDate today);
}
