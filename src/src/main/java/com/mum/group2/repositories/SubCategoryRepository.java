package com.mum.group2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mum.group2.domain.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
//	@Query("SELECT sc FROM SubCategory sc")
//	public List<SubCategory> getFirst5Question();
//
//	//@Query(value = "SELECT q.* FROM question q, sub_category sc, QUESTION_SUBCAT qs where sc.sub_cat_id = :subCatId and q.question_id = qs.question_id and sc.sub_cat_id = qs.sub_cat_id ORDER BY RAND() LIMIT :numQuestionn", nativeQuery = true)
//	@Query("SELECT q FROM ")
//	public List<Question> getFirstNQuestion(@Param("subCatId") int subCatId, @Param("numQuestionn") int numQuestionn);
	
	public SubCategory findByDescription(String description);
	
}
