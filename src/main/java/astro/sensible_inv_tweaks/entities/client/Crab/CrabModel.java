package astro.sensible_inv_tweaks.entities.client.Crab;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 5.2.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class CrabModel extends EntityModel<CrabRenderState> {
	private final ModelPart root;
	private final ModelPart torso;
	private final ModelPart rf_leg;
	private final ModelPart rm_leg;
	private final ModelPart rb_leg;
	private final ModelPart lf_leg;
	private final ModelPart lm_leg;
	private final ModelPart lb_leg;
	private final ModelPart small_claw;
	private final ModelPart big_claw;


	private final Animation walkAnimation;

	public CrabModel(ModelPart root) {
        super(root);
        this.root = root.getChild("root");
		this.torso = this.root.getChild("torso");
		this.rf_leg = this.root.getChild("rf_leg");
		this.rm_leg = this.root.getChild("rm_leg");
		this.rb_leg = this.root.getChild("rb_leg");
		this.lf_leg = this.root.getChild("lf_leg");
		this.lm_leg = this.root.getChild("lm_leg");
		this.lb_leg = this.root.getChild("lb_leg");
		this.small_claw = this.root.getChild("small_claw");
		this.big_claw = this.root.getChild("big_claw");

		this.walkAnimation = CrabAnimations.WALK.createAnimation(root);
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.of(0.0F, 20.5F, 0.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData torso = root.addChild("torso", ModelPartBuilder.create().uv(0, 11).cuboid(-3.5F, -2.0F, -3.5F, 7.0F, 4.0F, 7.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-3.5F, -3.0F, -3.5F, 7.0F, 4.0F, 7.0F, new Dilation(0.25F)), ModelTransform.origin(0.0F, 0.0F, 0.0F));

		ModelPartData rf_leg = root.addChild("rf_leg", ModelPartBuilder.create().uv(20, 27).cuboid(-3.75F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.5F, 2.0F, 2.0F, -0.0744F, 0.158F, -0.4422F));

		ModelPartData rm_leg = root.addChild("rm_leg", ModelPartBuilder.create().uv(20, 27).cuboid(-3.75F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.75F, 2.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		ModelPartData rb_leg = root.addChild("rb_leg", ModelPartBuilder.create().uv(20, 27).cuboid(-3.75F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-3.5F, 2.0F, -2.0F, 0.0744F, -0.158F, -0.4422F));

		ModelPartData lf_leg = root.addChild("lf_leg", ModelPartBuilder.create().uv(20, 28).cuboid(-0.25F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, 2.0F, 2.0F, -0.0744F, -0.158F, 0.4422F));

		ModelPartData lm_leg = root.addChild("lm_leg", ModelPartBuilder.create().uv(20, 28).cuboid(-0.25F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.75F, 2.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		ModelPartData lb_leg = root.addChild("lb_leg", ModelPartBuilder.create().uv(20, 28).cuboid(-0.25F, 0.0F, -0.5F, 4.0F, 0.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.5F, 2.0F, -2.0F, 0.0744F, 0.158F, 0.4422F));

		ModelPartData small_claw = root.addChild("small_claw", ModelPartBuilder.create().uv(20, 22).cuboid(-3.0F, -1.5F, -1.0F, 4.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(5.5F, 0.5F, 4.5F, -0.0939F, 0.3367F, -0.2778F));

		ModelPartData big_claw = root.addChild("big_claw", ModelPartBuilder.create(), ModelTransform.of(-6.75F, 0.0F, 4.25F, -0.0608F, -0.4323F, 0.1443F));

		ModelPartData cube_r1 = big_claw.addChild("cube_r1", ModelPartBuilder.create().uv(0, 22).cuboid(-4.0F, -5.0F, -1.0F, 7.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 2.5F, -0.5F, 0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(CrabRenderState crabRenderState) {
		this.getRootPart().traverse().forEach(ModelPart::resetTransform);

		super.setAngles(crabRenderState);

		this.walkAnimation.apply(crabRenderState.walkAnimationState, crabRenderState.age);
	}
}