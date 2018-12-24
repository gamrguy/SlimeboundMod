//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package slimebound.vfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import slimebound.orbs.CultistSlime;
import slimebound.orbs.ScrapOozeSlime;

public class ScrapGlowParticle extends AbstractGameEffect {
    private float x;
    private float y;
    private AtlasRegion img;
    private boolean activated = false;

    public ScrapOozeSlime p;
    private static int xOffset = -5;
    private static int yOffset = -28;
    private boolean reverse;
    public ScrapGlowParticle(ScrapOozeSlime p, Color color) {
        this.img = ImageMaster.GLOW_SPARK_2;
        this.scale = 0.006F;
        this.startingDuration = 0.5F;

        this.duration = this.startingDuration;
        this.renderBehind = MathUtils.randomBoolean(0.2F);
        this.color = color;
        this.activated = true;
        this.p = p;
        this.renderBehind = false;
    }

    public void finish(){
        this.isDone = true;

    }
    public void update() {

        if (reverse){
            this.scale = Interpolation.linear.apply(.15F, .2F, this.duration / (this.startingDuration / 2.0F));
        } else{
            this.scale = Interpolation.linear.apply(.2F, .15F, this.duration / (this.startingDuration / 2.0F));

        }
        this.duration -= Gdx.graphics.getDeltaTime();
        if (this.duration <= 0F) {
            reverse = !reverse;
            this.duration = 0.5F;
        }

    }

    public void render(SpriteBatch sb) {
        sb.setColor(Color.BLACK);
        sb.draw(this.img, this.p.attachmentGlowX + this.p.animX + this.p.cX + ((xOffset) * Settings.scale), this.p.attachmentGlowY + p.animY + this.p.cY + ((yOffset) * Settings.scale), (float)this.img.packedWidth / 2.0F, (float)this.img.packedHeight / 2.0F, (float)this.img.packedWidth, (float)this.img.packedHeight, this.scale * 2.0F, this.scale * 2.0F, this.rotation);
        sb.setColor(this.color);
        sb.draw(this.img, this.p.attachmentGlowX + this.p.animX + this.p.cX + ((xOffset) * Settings.scale), this.p.attachmentGlowY + p.animY + this.p.cY + ((yOffset) * Settings.scale), (float)this.img.packedWidth / 2.0F, (float)this.img.packedHeight / 2.0F, (float)this.img.packedWidth, (float)this.img.packedHeight, this.scale * 2.0F, this.scale * 2.0F, this.rotation);
    }


    public void dispose() {
    }
}