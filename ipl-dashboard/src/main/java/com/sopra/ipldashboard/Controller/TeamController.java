package com.sopra.ipldashboard.Controller;

import com.sopra.ipldashboard.Repository.MatchRepository;
import com.sopra.ipldashboard.Repository.TeamRepository;
import com.sopra.ipldashboard.model.Match;
import com.sopra.ipldashboard.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;


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

    @RequestMapping(value = "/team/{teamName}/matches", method = RequestMethod.GET)
    public List<Match> getMatchesForTeam(@PathVariable String teamName,
                                         @RequestParam int year)
    {
        LocalDate startDate = LocalDate.of(year, 1 , 1);
        LocalDate endDate = LocalDate.of(year+1 , 1 , 1);
        return this.matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);
    }

    @RequestMapping(value = "/team" ,method = RequestMethod.GET)
    public Iterable<Team> getAllTeam()
    {
       return this.teamRepository.findAll();
    }
}
