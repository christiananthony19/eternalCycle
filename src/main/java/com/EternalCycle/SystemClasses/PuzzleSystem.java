package com.EternalCycle.SystemClasses;

import com.EternalCycle.DataAccessObject.PuzzlesDao;
import com.EternalCycle.TableClasses.Puzzle;

import java.util.List;

public class PuzzleSystem {

    private final PuzzlesDao puzzleDao = new PuzzlesDao();

    public List<Puzzle> getPuzzlesByLocationId(int locationId) {
        return puzzleDao.GetPuzzlesByLocationId(locationId);
    }

    public Puzzle GetPuzzleById(int puzzleId) {
        return puzzleDao.GetPuzzleById(puzzleId);
    }
}
