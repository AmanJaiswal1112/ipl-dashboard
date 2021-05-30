package com.sopra.ipldashboard.Repository;

import com.sopra.ipldashboard.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long>
{
    Team findByTeamName(String teamName);
}
