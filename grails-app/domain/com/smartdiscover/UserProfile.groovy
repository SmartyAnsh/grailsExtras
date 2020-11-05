package com.smartdiscover

import com.smartdiscover.datatypes.PGEnumUserType

enum Gender {M,F,O}; //Male, Female, Others

class UserProfile {

    String firstName
    String lastName
    Gender gender

    static constraints = {
        firstName nullable: false, blank: false
        lastName nullable: false, blank: false
        gender nullable: false, blank: false
    }

    static mapping = {
        gender column: 'gender', type : PGEnumUserType, params :  [enumClassName:  "com.smartdiscover.Gender" ]
    }
}
