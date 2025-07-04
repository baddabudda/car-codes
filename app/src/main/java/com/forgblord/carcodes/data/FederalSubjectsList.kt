package com.forgblord.carcodes.data

object FederalSubjectsList {
    private val data: MutableList<FederalSubject> = mutableListOf(
        FederalSubject(name="Республика Адыгея", codes=listOf("01", "101")),
        FederalSubject(name="Республика Башкортостан", codes=listOf("02", "102", "702")),
        FederalSubject(name="Республика Бурятия", codes=listOf("03", "103")),
        FederalSubject(name="Республика Алтай", codes=listOf("04")),
        FederalSubject(name="Республика Дагестан", codes=listOf("05")),
        FederalSubject(name="Республика Ингушетия", codes=listOf("06")),
        FederalSubject(name="Кабардино-Балкарская Республика", codes=listOf("07")),
        FederalSubject(name="Республика Калмыкия", codes=listOf("08")),
        FederalSubject(name="Карачаево-Черкесская Республика", codes=listOf("09", "109")),
        FederalSubject(name="Республика Карелия", codes=listOf("10")),
        FederalSubject(name="Республика Коми (Сыктывкар)", codes=listOf("11", "111")),
        FederalSubject(name="Республика Марий Эл", codes=listOf("12")),
        FederalSubject(name="Республика Мордовия", codes=listOf("13", "113")),
        FederalSubject(name="Республика Саха (Якутия)", codes=listOf("14")),
        FederalSubject(name="Республика Северная Осетия — Алания", codes=listOf("15")),
        FederalSubject(name="Республика Татарстан", codes=listOf("16", "116", "716")),
        FederalSubject(name="Республика Тыва", codes=listOf("17")),
        FederalSubject(name="Удмуртская Республика", codes=listOf("18", "118")),
        FederalSubject(name="Республика Хакасия", codes=listOf("19")),
        FederalSubject(name="Чеченская Республика", codes=listOf("20", "95")),
        FederalSubject(name="Чувашская Республика (Чувашия)", codes=listOf("21", "121")),
        FederalSubject(name="Алтайский край", codes=listOf("22", "122")),
        FederalSubject(name="Краснодарский край", codes=listOf("23", "93", "123", "193", "323")),
        FederalSubject(name="Красноярский край", codes=listOf("24", "84", "88", "124")),
        FederalSubject(name="Приморский край", codes=listOf("25", "125", "725")),
        FederalSubject(name="Ставропольский край", codes=listOf("26", "126")),
        FederalSubject(name="Хабаровский край", codes=listOf("27")),
        FederalSubject(name="Амурская область", codes=listOf("28")),
        FederalSubject(name="Архангельская область", codes=listOf("29")),
        FederalSubject(name="Астраханская область", codes=listOf("30", "130")),
        FederalSubject(name="Белгородская область", codes=listOf("31")),
        FederalSubject(name="Брянская область", codes=listOf("32")),
        FederalSubject(name="Владимирская область", codes=listOf("33")),
        FederalSubject(name="Волгоградская область", codes=listOf("34", "134")),
        FederalSubject(name="Вологодская область", codes=listOf("35")),
        FederalSubject(name="Воронежская область", codes=listOf("36", "136")),
        FederalSubject(name="Ивановская область", codes=listOf("37")),
        FederalSubject(name="Иркутская область", codes=listOf("38", "138")),
        FederalSubject(name="Калининградская область", codes=listOf("39", "91", "139")),
        FederalSubject(name="Калужская область", codes=listOf("40")),
        FederalSubject(name="Камчатский край", codes=listOf("41")),
        FederalSubject(name="Кемеровская область (Кузбасс)", codes=listOf("42", "142")),
        FederalSubject(name="Кировская область", codes=listOf("43")),
        FederalSubject(name="Костромская область", codes=listOf("44")),
        FederalSubject(name="Курганская область", codes=listOf("45")),
        FederalSubject(name="Курская область", codes=listOf("46")),
        FederalSubject(name="Ленинградская область", codes=listOf("47", "147")),
        FederalSubject(name="Липецкая область", codes=listOf("48")),
        FederalSubject(name="Магаданская область", codes=listOf("49")),
        FederalSubject(name="Московская область", codes=listOf("50", "90", "150", "190", "250", "550", "750", "790")),
        FederalSubject(name="Мурманская область", codes=listOf("51")),
        FederalSubject(name="Нижегородская область", codes=listOf("52", "152", "252")),
        FederalSubject(name="Новгородская область", codes=listOf("53")),
        FederalSubject(name="Новосибирская область", codes=listOf("54", "154", "754")),
        FederalSubject(name="Омская область", codes=listOf("55", "155")),
        FederalSubject(name="Оренбургская область", codes=listOf("56", "156")),
        FederalSubject(name="Орловская область", codes=listOf("57")),
        FederalSubject(name="Пензенская область", codes=listOf("58", "158")),
        FederalSubject(name="Пермский край", codes=listOf("59", "59")),
        FederalSubject(name="Псковская область", codes=listOf("60")),
        FederalSubject(name="Ростовская область", codes=listOf("61", "161", "761")),
        FederalSubject(name="Рязанская область", codes=listOf("62")),
        FederalSubject(name="Самарская область", codes=listOf("63", "163", "763")),
        FederalSubject(name="Саратовская область", codes=listOf("64", "164")),
        FederalSubject(name="Сахалинская область", codes=listOf("65")),
        FederalSubject(name="Свердловская область (Екатеринбург)", codes=listOf("66", "96", "196")),
        FederalSubject(name="Смоленская область", codes=listOf("67")),
        FederalSubject(name="Тамбовская область", codes=listOf("68")),
        FederalSubject(name="Тверская область", codes=listOf("69", "169")),
        FederalSubject(name="Томская область", codes=listOf("70")),
        FederalSubject(name="Тульская область", codes=listOf("71")),
        FederalSubject(name="Тюменская область", codes=listOf("72", "172")),
        FederalSubject(name="Ульяновская область", codes=listOf("73", "173")),
        FederalSubject(name="Челябинская область", codes=listOf("74", "174", "774")),
        FederalSubject(name="Забайкальский край", codes=listOf("75")),
        FederalSubject(name="Ярославская область", codes=listOf("76")),
        FederalSubject(name="Москва", codes=listOf("77", "97", "99", "177", "197", "199", "777", "797", "799", "977")),
        FederalSubject(name="Санкт-Петербург", codes=listOf("78", "98", "178", "198")),
        FederalSubject(name="Еврейская автономная область", codes=listOf("79")),
        FederalSubject(name="Донецкая Народная Республика (ДНР)", codes=listOf("80", "180")),
        FederalSubject(name="Луганская Народная Республика (ЛНР)", codes=listOf("81", "181")),
        FederalSubject(name="Республика Крым", codes=listOf("82", "182")),
        FederalSubject(name="Ненецкий автономный округ", codes=listOf("83")),
        FederalSubject(name="Херсонская область", codes=listOf("84", "184")),
        FederalSubject(name="Запорожская область", codes=listOf("85", "185")),
        FederalSubject(name="Ханты-Мансийский автономный округ (Югра)", codes=listOf("86", "186")),
        FederalSubject(name="Чукотский автономный округ", codes=listOf("87")),
        FederalSubject(name="Ямало-Ненецкий автономный округ", codes=listOf("89")),
        FederalSubject(name="Севастополь", codes=listOf("92", "192")),
        FederalSubject(name="Харьковская область", codes=listOf("188"))
    )

    private fun formatQuery(query: String?): String {
        var queryFormatted = ""

        if (!query.isNullOrEmpty()) {
            queryFormatted = query.lowercase()
        }

        return queryFormatted
    }

    private fun containsQuery(subject: FederalSubject, query: String): Boolean {
        if (subject.name.lowercase().contains(query)) {
            return true
        }

        for (code in subject.codes) {
            if (code.contains(query)) {
                return true
            }
        }

        return false
    }

    private fun sortByName() {
        data.sortBy { federalSubject ->
            federalSubject.name
        }
    }

    private fun sortByCode() {
        data.sortBy { federalSubject ->
            federalSubject.codes[0].toInt()
        }
    }

    fun search(query: String?): List<FederalSubject> {
        val queryFormatted = formatQuery(query)

        if (queryFormatted.isEmpty()) {
            return data
        }

        val searchResult: MutableList<FederalSubject> = mutableListOf()

        for (subject in data) {
            if (containsQuery(subject, queryFormatted)) {
                searchResult.add(subject)
            }
        }

        return searchResult
    }

    fun sort(order: SortOrder): List<FederalSubject> {
        when (order) {
            SortOrder.BY_NAME -> sortByName()
            SortOrder.BY_CODE -> sortByCode()
        }

        return data
    }
}
