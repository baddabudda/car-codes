package com.forgblord.carcodes.data

object SubjectDataProvider {
    val subjectList: List<FederalSubject> = federalSubjectsList

    private fun containsQuery(subject: FederalSubject, query: String): Boolean {
        if (subject.name.lowercase().contains(query)) {
            return true
        }

        for (code in subject.codes) {
            if (code.toString().contains(query)) {
                return true
            }
        }

        return false
    }

    fun search(query: String?): List<FederalSubject> {
        if (query.isNullOrEmpty()) {
            return subjectList
        }

        val resultList: MutableList<FederalSubject> = mutableListOf()
        val queryLowercased = query.lowercase()

        for (subject in subjectList) {
            // val has = subject.codes.map { item -> item.toString().contains(query) }
            if (containsQuery(subject, queryLowercased)) {
                resultList.add(subject)
            }
        }

        return resultList
    }
}