/**
 * Copyright (C) 2011-2012 The XDocReport Team <xdocreport@googlegroups.com>
 *
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package fr.opensagres.xdocreport.document.pptx.discovery;

import static fr.opensagres.xdocreport.document.pptx.PPTXConstants.DESCRIPTION_DISCOVERY;
import static fr.opensagres.xdocreport.document.pptx.PPTXConstants.ID_DISCOVERY;
import static fr.opensagres.xdocreport.document.pptx.PPTXConstants.MIME_MAPPING;
import fr.opensagres.xdocreport.converter.MimeMapping;
import fr.opensagres.xdocreport.core.io.XDocArchive;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.discovery.AbstractXDocReportFactoryDiscovery;
import fr.opensagres.xdocreport.document.discovery.IXDocReportFactoryDiscovery;
import fr.opensagres.xdocreport.document.pptx.PPTXReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;

/**
 * Open Office ODP discovery used by the {@link XDocReportRegistry#loadReport(java.io.InputStream)} to create an
 * instance of {@link PPTXReport} if input stream to load is an ODP.
 */
public class PPTXReportFactoryDiscovery
    extends AbstractXDocReportFactoryDiscovery
    implements IXDocReportFactoryDiscovery
{

    public boolean isAdaptFor( XDocArchive archive )
    {
        return PPTXReport.isPPTX( archive );
    }

    public IXDocReport createReport()
    {
        return new PPTXReport();
    }

    public MimeMapping getMimeMapping()
    {
        return MIME_MAPPING;
    }

    public String getDescription()
    {
        return DESCRIPTION_DISCOVERY;
    }

    public String getId()
    {
        return ID_DISCOVERY;
    }

    public Class<?> getReportClass()
    {
        return PPTXReport.class;
    }

}
