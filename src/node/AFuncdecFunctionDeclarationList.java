/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AFuncdecFunctionDeclarationList extends PFunctionDeclarationList
{
    private PFunctionDeclaration _functionDeclaration_;

    public AFuncdecFunctionDeclarationList()
    {
        // Constructor
    }

    public AFuncdecFunctionDeclarationList(
        @SuppressWarnings("hiding") PFunctionDeclaration _functionDeclaration_)
    {
        // Constructor
        setFunctionDeclaration(_functionDeclaration_);

    }

    @Override
    public Object clone()
    {
        return new AFuncdecFunctionDeclarationList(
            cloneNode(this._functionDeclaration_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFuncdecFunctionDeclarationList(this);
    }

    public PFunctionDeclaration getFunctionDeclaration()
    {
        return this._functionDeclaration_;
    }

    public void setFunctionDeclaration(PFunctionDeclaration node)
    {
        if(this._functionDeclaration_ != null)
        {
            this._functionDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._functionDeclaration_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._functionDeclaration_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._functionDeclaration_ == child)
        {
            this._functionDeclaration_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._functionDeclaration_ == oldChild)
        {
            setFunctionDeclaration((PFunctionDeclaration) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
