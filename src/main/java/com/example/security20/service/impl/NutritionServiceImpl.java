package com.example.security20.service.impl;

import com.example.security20.entity.Nutrition;
import com.example.security20.entity.NutritionPlan;
import com.example.security20.entity.WeekNutrition;
import com.example.security20.repository.NutritionPlanRepository;
import com.example.security20.repository.NutritionRepository;
import com.example.security20.repository.WeekNutritionRepository;
import com.example.security20.service.NutritionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NutritionServiceImpl implements NutritionService {
    @Autowired
    NutritionRepository nutritionRepository;
    @Autowired
    WeekNutritionRepository weekNutritionRepository;
    @Autowired
    NutritionPlanRepository nutritionPlanRepository;

    @Override
    public void saveNutrition(Nutrition nutrition) {
        nutritionRepository.save(nutrition);
    }

    @Override
    public List<Nutrition> getNutritionByUserId(Long userId) {
        return nutritionRepository.getNutritionByUserId(userId);
    }

    @Transactional
    @Override
    public void deletePlanById(Long id) {
        nutritionPlanRepository.deleteById(id);
    }


    @Override
    public WeekNutrition findLastWeekNutritionByUserIdAndWeekStart(Long userId, Date startWeek) {
        return weekNutritionRepository.findLastWeekNutritionByUserIdAndWeekStart(userId, startWeek);
    }

    @Override
    public WeekNutrition findLastWeekNutritionByUserId(Long userId) {
        return weekNutritionRepository.findLastWeekNutritionByUserId(userId);
    }

    @Transactional
    @Override
    public void updateWeekNutrition(Long userId, int countDaysOfWeek, Date lastDate, Date startWeek, String checkDays, Double sumCalories, Double sumProteins, Double sumFats, Double sumCarbohydrates) {
        weekNutritionRepository.updateWeekNutrition(userId,
                                                    countDaysOfWeek,
                                                    lastDate,
                                                    startWeek,
                                                    checkDays,
                                                    sumCalories,
                                                    sumProteins,
                                                    sumFats,
                                                    sumCarbohydrates);
    }

    @Override
    public void saveWeekNutrition(WeekNutrition weekNutrition) {
        weekNutritionRepository.save(weekNutrition);
    }

    @Override
    public void saveNutritionPlan(NutritionPlan nutritionPlan) {
        nutritionPlanRepository.save(nutritionPlan);
    }

    @Override
    public NutritionPlan getLastNutritionPlanByUserId(Long userId) {
        return nutritionPlanRepository.findLastNutritionPlanByUserId(userId);
    }

    @Override
    public List<NutritionPlan> getNutritionPlanByUserId(Long userId) {
        return nutritionPlanRepository.findNutritionPlanByUserId(userId);
    }
}
