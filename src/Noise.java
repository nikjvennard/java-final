public class Noise {

    dMath dm = new dMath();

    //Perlin noise function -- https://en.wikipedia.org/wiki/Perlin_noise
    public double pNoise(Vec2 uv, double scale)
    {

        Vec2 lv = vMath.fract(vMath.mult(uv, scale));
        lv.x = dMath.smoothstep(0, 1, lv.x);
        lv.y = dMath.smoothstep(0, 1, lv.y);

        Vec2 id = vMath.floor(vMath.mult(uv, scale));

        double bl = dm.N21(id);
        double br = dm.N21(vMath.add(id, new Vec2(1, 0)));
        double bm = dMath.mix(bl, br, lv.x);

        double tl = dm.N21(vMath.add(id, new Vec2(0, 1)));
        double tr = dm.N21(vMath.add(id, new Vec2(1, 1)));
        double tm = dMath.mix(tl, tr, lv.x);

        return dMath.mix(bm, tm, lv.y);

    }

    //Perlin Noise with Octaves
    public double pNoise(Vec2 uv, double scale, int octave)
    {
        double oNoise = 0.0;
        //SAFETY CHECK FOR DIV BY 0 AND NEGATIVE OCTAVES
        if (octave <= 0) {
            octave = 1;
        }

        for (int i = 1; i < octave; i++) {
            oNoise += pNoise(uv, i * 10) * (1 / Math.pow(2, i));
        }

        return oNoise;
    }

}
