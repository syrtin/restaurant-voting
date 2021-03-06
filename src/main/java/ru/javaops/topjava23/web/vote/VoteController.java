package ru.javaops.topjava23.web.vote;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.javaops.topjava23.model.Vote;
import ru.javaops.topjava23.repository.VoteRepository;
import ru.javaops.topjava23.service.VoteService;
import ru.javaops.topjava23.web.AuthUser;

import java.time.LocalDate;

@RestController
@RequestMapping(value = VoteController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@AllArgsConstructor
@Tag(name = "Vote Controller")
public class VoteController {

    static final String REST_URL = "/api/vote";

    private final VoteRepository voteRepository;
    private final VoteService voteService;

    @GetMapping
    public ResponseEntity<Vote> getByUserToday(@AuthenticationPrincipal AuthUser authUser) {
        return ResponseEntity.of(voteRepository.getByUserAndDate(authUser.id(), LocalDate.now()));
    }

    @GetMapping("/by")
    public ResponseEntity<Vote> getByUserAndDate(@AuthenticationPrincipal AuthUser authUser,
                                                 @RequestParam @Nullable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.of(voteRepository.getByUserAndDate(authUser.id(), date));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@AuthenticationPrincipal AuthUser authUser, @RequestParam int restaurantId) {
        int userId = authUser.id();
        log.info("create vote of user {} for restaurant {}", userId, restaurantId);
        voteService.create(userId, restaurantId);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@AuthenticationPrincipal AuthUser authUser, @RequestParam int restaurantId) {
        int userId = authUser.id();
        log.info("update vote of user {} for restaurant {}", userId, restaurantId);
        voteService.update(userId, restaurantId);
    }
}
