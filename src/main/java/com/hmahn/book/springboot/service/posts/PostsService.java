package com.hmahn.book.springboot.service.posts;

import com.hmahn.book.springboot.domain.posts.Posts;
import com.hmahn.book.springboot.domain.posts.PostsRepository;
import com.hmahn.book.springboot.web.dto.PostsListResponseDto;
import com.hmahn.book.springboot.web.dto.PostsResponseDto;
import com.hmahn.book.springboot.web.dto.PostsSaveRequestDto;

import com.hmahn.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    public PostsResponseDto findById(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. ID="+id));

        return new PostsResponseDto(posts);
    }

    //@Transactional(readOnly = true) 트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도 개선
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {

        //.map(PostsListResponseDto::new) => .map(posts -> new PostsListResponseDto(posts))
        // postsRepository findAllDesc 메소드에서 가져온 Posts의 stream을 map을 통해 PostsListResponseDto로 변환

        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
}
