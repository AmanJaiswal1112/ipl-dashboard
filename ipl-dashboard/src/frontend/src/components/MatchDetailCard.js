import { React } from 'react';
import {Link} from "react-router-dom";


export const MatchDetailCard = ({teamName, match}) => {
    if (!match) return null;
    const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
    const otherTeamRoute = `/teams/${otherTeam}`;
    return (
        <div className="MatchDetailCard">
            <h3>Latest Matches</h3>
            <h4>Match Details</h4>
            <h3>vs <Link to={otherTeamRoute}> {otherTeam}</Link></h3>
            <h2>{match.date}</h2>
            <h3>{match.venue}</h3>
            <h3>{match.matchWinner} Won by {match.matchResult} {match.result}</h3>
        </div>
    );
}