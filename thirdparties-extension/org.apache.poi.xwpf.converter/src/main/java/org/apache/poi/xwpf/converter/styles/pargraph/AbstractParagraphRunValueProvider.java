package org.apache.poi.xwpf.converter.styles.pargraph;

import org.apache.poi.xwpf.converter.styles.AbstractValueProvider;
import org.apache.poi.xwpf.converter.styles.XWPFStylesDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocDefaults;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTParaRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPrDefault;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;

public abstract class AbstractParagraphRunValueProvider<Value>
    extends AbstractValueProvider<Value, XWPFParagraph>
{

    public CTParaRPr getCTParaRPr( XWPFParagraph paragraph )
    {
        return paragraph.getCTP().getPPr().getRPr();
    }

    public CTRPr getRPr( CTStyle style )
    {
        return style.getRPr();
    }

    public CTRPr getRPr( CTDocDefaults docDefaults )
    {
        CTRPrDefault prDefault = docDefaults.getRPrDefault();
        if ( prDefault == null )
        {
            return null;
        }
        return prDefault.getRPr();
    }

    @Override
    public Value getValueFromElement( XWPFParagraph paragraph )
    {
        return getValue( getCTParaRPr( paragraph ) );
    }

    @Override
    protected Value getValueFromStyle( CTStyle style )
    {
        return getValue( getRPr( style ) );
    }

    @Override
    protected Value getValueFromDocDefaultsStyle( CTDocDefaults docDefaults )
    {
        return getValue( getRPr( docDefaults ) );
    }

    public abstract Value getValue( CTParaRPr ppr );

    public abstract Value getValue( CTRPr ppr );

    @Override
    protected String[] getStyleID( XWPFParagraph paragraph )
    {
        CTParaRPr rPr = getCTParaRPr( paragraph );
        if ( rPr != null )
        {
            CTString style = rPr.getRStyle();
            if ( style != null )
            {
                return new String[] { paragraph.getStyleID(), style.getVal() };
            }
        }
        return new String[] { paragraph.getStyleID() };
    }

    @Override
    protected CTStyle getDefaultStyle( XWPFParagraph element, XWPFStylesDocument styleManager )
    {
        return styleManager.getDefaultParagraphStyle();
    }
}
