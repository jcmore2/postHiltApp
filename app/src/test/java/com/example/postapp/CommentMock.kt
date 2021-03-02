package com.example.postapp

import com.example.postapp.model.api.CommentApiDTO
import com.example.postapp.model.canon.Comment
import com.example.postapp.model.local.CommentLocalDTO

object CommentMock {

    val commentListMock = listOf<Comment>(
        Comment(
            1,
            1,
            "id labore ex et quam laborum",
            "Eliseo@gardner.biz",
            "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
        ),
        Comment(
            1,
            2,
            "id labore",
            "ayne_Kuhic@sydney.com",
            "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
        ),
        Comment(
            1,
            3,
            "id labore",
            "Nikita@garfield.biz",
            "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
        )
    )

    val commentLocalDTOListMock = listOf<CommentLocalDTO>(
        CommentLocalDTO(
            1,
            1,
            "id labore ex et quam laborum",
            "Eliseo@gardner.biz",
            "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
        ),
        CommentLocalDTO(
            1,
            2,
            "id labore",
            "ayne_Kuhic@sydney.com",
            "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
        ),
        CommentLocalDTO(
            1,
            3,
            "id labore",
            "Nikita@garfield.biz",
            "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
        )
    )

    val commentApiDTOListMock = listOf<CommentApiDTO>(
        CommentApiDTO(
            1,
            1,
            "id labore ex et quam laborum",
            "Eliseo@gardner.biz",
            "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
        ),
        CommentApiDTO(
            1,
            2,
            "id labore",
            "ayne_Kuhic@sydney.com",
            "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
        ),
        CommentApiDTO(
            1,
            3,
            "id labore",
            "Nikita@garfield.biz",
            "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
        )
    )

    val comment = Comment(
        1,
        1,
        "id labore ex et quam laborum",
        "Eliseo@gardner.biz",
        "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
    )

    val commentLocalDTO = CommentLocalDTO(
        1,
        1,
        "id labore ex et quam laborum",
        "Eliseo@gardner.biz",
        "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
    )

    val commentApiDTO = CommentApiDTO(
        1,
        1,
        "id labore ex et quam laborum",
        "Eliseo@gardner.biz",
        "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
    )
}