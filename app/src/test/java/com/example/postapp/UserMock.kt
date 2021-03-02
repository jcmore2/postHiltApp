package com.example.postapp

import com.example.postapp.model.api.UserApiDTO
import com.example.postapp.model.canon.User
import com.example.postapp.model.local.UserLocalDTO

object UserMock {

    val userListMock = listOf<User>(
        User(
            1,
            "Leanne Graham",
            "Bret",
            "Sincere@april.biz",
            "1-770-736-8031 x56442",
            "hildegard.org"
        ),
        User(
            2,
            "Ervin Howell",
            "Antonette",
            "Shanna@melissa.tv",
            "1-770-736-8031 x56442",
            "anastasia.net"
        ),
        User(
            3,
            "Clementine Bauch",
            "Samantha",
            "Nathan@yesenia.net",
            "1-770-736-8031 x56442",
            "ramiro.info"
        )
    )

    val userLocalDTOListMock = listOf<UserLocalDTO>(
        UserLocalDTO(
            1,
            "Leanne Graham",
            "Bret",
            "Sincere@april.biz",
            "1-770-736-8031 x56442",
            "hildegard.org"
        ),
        UserLocalDTO(
            2,
            "Ervin Howell",
            "Antonette",
            "Shanna@melissa.tv",
            "1-770-736-8031 x56442",
            "anastasia.net"
        ),
        UserLocalDTO(
            3,
            "Clementine Bauch",
            "Samantha",
            "Nathan@yesenia.net",
            "1-770-736-8031 x56442",
            "ramiro.info"
        )
    )

    val userApiDTOListMock = listOf<UserApiDTO>(
        UserApiDTO(
            1,
            "Leanne Graham",
            "Bret",
            "Sincere@april.biz",
            "1-770-736-8031 x56442",
            "hildegard.org"
        ),
        UserApiDTO(
            2,
            "Ervin Howell",
            "Antonette",
            "Shanna@melissa.tv",
            "1-770-736-8031 x56442",
            "anastasia.net"
        ),
        UserApiDTO(
            3,
            "Clementine Bauch",
            "Samantha",
            "Nathan@yesenia.net",
            "1-770-736-8031 x56442",
            "ramiro.info"
        )
    )

    val userMock = User(
    1,
    "Leanne Graham",
    "Bret",
    "Sincere@april.biz",
    "1-770-736-8031 x56442",
    "hildegard.org"
    )

    val userLocalDTOMock = UserLocalDTO(
        1,
        "Leanne Graham",
        "Bret",
        "Sincere@april.biz",
        "1-770-736-8031 x56442",
        "hildegard.org"
    )

    val userApiDTOMock = UserApiDTO(
        1,
        "Leanne Graham",
        "Bret",
        "Sincere@april.biz",
        "1-770-736-8031 x56442",
        "hildegard.org"
    )
}