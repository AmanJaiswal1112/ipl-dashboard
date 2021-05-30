package com.sopra.ipldashboard.Controller;

import com.sopra.ipldashboard.Repository.MatchRepository;
import com.sopra.ipldashboard.Repository.TeamRepository;
import com.sopra.ipldashboard.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class TeamController
{
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MatchRepository matchRepository;

    @RequestMapping(value = "/team/{teamName}", method = RequestMethod.GET)
    public Team getTeam(@PathVariable String teamName)
    {
        Team team =teamRepository.findByTeamName(teamName);
        team.setMatches(matchRepository.findLatestMatchByTeam(teamName, 4));

        return team;
    }
}
