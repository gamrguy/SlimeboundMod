/*    */ package slimebound.cards;
/*    */

import basemod.abstracts.CustomCard;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.BorderFlashEffect;
import com.megacrit.cardcrawl.vfx.combat.IntenseZoomEffect;
import slimebound.SlimeboundMod;
import slimebound.patches.AbstractCardEnum;
import slimebound.powers.*;

import java.util.Random;

/*    */
/*    */ public class StudyRandomBoss extends CustomCard
        /*    */ {
    /*    */   public static final String ID = "StudyRandomBoss";
    /*    */
                private static final CardStrings cardStrings;
                public static final String NAME;
                public static final String DESCRIPTION;
    public static String UPGRADED_DESCRIPTION;
    /*    */   public static final String IMG_PATH = "cards/studyspire.png";
    /* 17 */   private static final CardType TYPE = CardType.POWER;
    /* 18 */   private static final CardRarity RARITY = CardRarity.RARE;
    /* 19 */   private static final CardTarget TARGET = CardTarget.SELF;
    /*    */
    /*    */   private static final int COST = 2;

    /*    */   private static int upgradedamount = 1;
    /*    */
    /*    */   public StudyRandomBoss()
    /*    */   {
        /* 27 */     super(ID, NAME, SlimeboundMod.getResourcePath(IMG_PATH), COST, DESCRIPTION, TYPE, AbstractCardEnum.SLIMEBOUND, RARITY, TARGET);
                    this.magicNumber = this.baseMagicNumber = 3;


        /*    */   }
    /*    */
    /*    */   public void use(AbstractPlayer p, AbstractMonster m)
    /*    */ {
        AbstractDungeon.actionManager.addToBottom(new VFXAction(p, new BorderFlashEffect(Color.GREEN, true), 0.05F, true));
        AbstractDungeon.actionManager.addToBottom(new VFXAction(p, new IntenseZoomEffect(p.hb.cX,p.hb.cY,false), 0.05F));


        Random random = new Random();
        Integer chosenRand = random.nextInt(8) + 1;

        switch(chosenRand){
            case 1:             AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StudyAutomatonPower(p, p, this.magicNumber), this.magicNumber)); break;
            case 2:            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StudyAwakenedPower(p, p, this.magicNumber), this.magicNumber)); break;

            case 3:            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StudyChampPower(p, p, this.magicNumber), this.magicNumber)); break;

            case 4:            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StudyCollectorPower(p, p, this.magicNumber), this.magicNumber)); break;

            case 5:            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StudyGuardianPower(p, p, this.magicNumber), this.magicNumber)); break;

            case 6:            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StudyHexaghostPower(p, p, this.magicNumber), this.magicNumber)); break;

            case 7:            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StudyShapesPower(p, p, this.magicNumber), this.magicNumber)); break;

            case 8:            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StudyTimeEaterPower(p, p, this.magicNumber), this.magicNumber)); break;

        }

    }
    /*    */
    /*    */   public AbstractCard makeCopy()
    /*    */   {
        /* 40 */     return new StudyRandomBoss();
        /*    */   }
    /*    */
    /*    */   public void upgrade()
    /*    */   {
        /* 45 */     if (!this.upgraded)
            /*    */     {
            /* 47 */       upgradeName();
            upgradeBaseCost(1);


            /*    */     }
        /*    */   }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADED_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }
    /*    */ }
