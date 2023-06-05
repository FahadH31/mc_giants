package net.fahad.giants_mod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class GiantEntity extends Monster implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public GiantEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes(){
       return Monster.createMobAttributes()
               .add(Attributes.ATTACK_DAMAGE, 15.0f)
               .add(Attributes.ATTACK_SPEED, 1.0f)
               .add(Attributes.MOVEMENT_SPEED, 0.23f)
               .add(Attributes.MAX_HEALTH, 400.0f)
               .add(Attributes.FOLLOW_RANGE, 40)
               .add(Attributes.ATTACK_KNOCKBACK, 10)
               .add(Attributes.KNOCKBACK_RESISTANCE, 1)
               .build();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 2.0D, false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
        controllerRegistrar.add(new AnimationController<>(this, "attackController", 0, this::attackPredicate));
    }

    private <T extends GeoAnimatable> PlayState attackPredicate(AnimationState<T> tAnimationState) {
        if(this.swinging && tAnimationState.getController().getAnimationState().equals(AnimationController.State.STOPPED)){
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.giant.attack", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
            return PlayState.CONTINUE;
        }
        return PlayState.CONTINUE;
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if(tAnimationState.isMoving()){
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.giant.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
