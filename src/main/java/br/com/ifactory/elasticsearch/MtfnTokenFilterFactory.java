package br.com.ifactory.elasticsearch;

import org.apache.commons.codec.Encoder;
import org.apache.commons.codec.EncoderException;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.phonetic.PhoneticFilter;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

import mtfn.MetaphonePtBr;

public class MtfnTokenFilterFactory extends AbstractTokenFilterFactory {

    private final Encoder encoder = new Encoder() {
        @Override
        public Object encode(Object source) throws EncoderException {
            if (!(source instanceof String)) {
                throw new EncoderException("Parameter supplied to MTFN encode is not of type java.lang.String"); 
            }
            return new MetaphonePtBr((String) source).toString();
        }
    };

    public MtfnTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, name, settings);
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new PhoneticFilter(tokenStream, this.encoder, true);
    }
}
